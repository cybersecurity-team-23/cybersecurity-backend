package rs.ac.uns.ftn.BookingBaboon.controllers.users;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.config.security.JwtTokenUtil;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.*;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestNotificationSettings;
import rs.ac.uns.ftn.BookingBaboon.helpers.HIBP;
import rs.ac.uns.ftn.BookingBaboon.helpers.PasswordHelper;
import rs.ac.uns.ftn.BookingBaboon.services.KeycloakService;
import rs.ac.uns.ftn.BookingBaboon.services.reservation.interfaces.IReservationService;
import rs.ac.uns.ftn.BookingBaboon.services.users.RecaptchaService;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IUserService;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final IUserService service;
    private final KeycloakService keycloakService;
    private final IReservationService reservationService;
    private final ModelMapper mapper;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final SecurityContext sc = SecurityContextHolder.getContext();

    @Autowired
    private RecaptchaService recaptchaService;


    @GetMapping
    public ResponseEntity<Collection<UserResponse>> getUsers() {
        Collection<User> users = service.getAll();
        Collection<UserResponse> userResponses =  users.stream()
                .map(user -> mapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }

    @GetMapping({"/{userId}"})
    public ResponseEntity<UserResponse> get(@PathVariable Long userId) {
        User user = service.get(userId);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( mapper.map(user, UserResponse.class), HttpStatus.OK);
    }

    @PostMapping({"/"})
    public ResponseEntity<UserResponse> create(@RequestBody UserCreateRequest user) {
        // check password validity
        if (!PasswordHelper.isValid(user.getPassword())) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        // run the password against HIBP
        try {
            // TODO: error message?
            if (HIBP.isPasswordBlacklisted(user.getPassword())) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String token = user.getRecaptchaToken();

        if (token == null) {
            System.out.println("Recaptcha token missing");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        if (!recaptchaService.verifyCaptcha(token)) {
            System.out.println("Recaptcha token invalid");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        String accessToken = "";
        try {
            accessToken = keycloakService.obtainAccessToken();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        boolean res;
        try {
            res = keycloakService.registerUser(UserCreationKeycloak.fromUserCreateRequest(user), accessToken);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (!res) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        this.service.create(mapper.map(user, User.class));
        return new ResponseEntity<>(mapper.map(user, UserResponse.class), HttpStatus.OK);
    }

    @PutMapping({"/"})
    public ResponseEntity<UserResponse> update(@RequestBody UserUpdateRequest user) {
        return new ResponseEntity<>(mapper.map(service.update(mapper.map(user, User.class)),UserResponse.class),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('GUEST', 'HOST', 'ADMIN')")
    @DeleteMapping({"/{userId}"})
    public ResponseEntity<UserResponse> remove(@PathVariable Long userId) {
        User user = service.remove(userId);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( mapper.map(user,UserResponse.class), HttpStatus.OK);
    }

/*    @PreAuthorize("hasAnyAuthority('GUEST', 'HOST', 'ADMIN')")
    @GetMapping({"/profile/{userEmail}"})
    public ResponseEntity<UserProfile> getProfile(@PathVariable String userEmail) {

        User user = service.getByEmail(userEmail);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( mapper.map(user, UserProfile.class), HttpStatus.OK);
    }*/

    @PreAuthorize("hasAnyAuthority('GUEST', 'HOST', 'ADMIN')")
    @GetMapping({"/profile/{userId}"})
    public ResponseEntity<UserProfile> getProfile(@PathVariable Long userId) {

        User user = service.get(userId);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( mapper.map(user, UserProfile.class), HttpStatus.OK);
    }

    @GetMapping({"/email/{userEmail}"})
    public ResponseEntity<UserResponse> getByEmail(@PathVariable String userEmail) {
        User user = service.getByEmail(userEmail);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( mapper.map(user, UserResponse.class), HttpStatus.OK);
    }

    @PostMapping({"/login"})
    public ResponseEntity<UserResponse> login(@RequestBody UserLoginRequest request){
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(request.getEmail(),
                request.getPassword());
        Authentication auth = authenticationManager.authenticate(authReq);

        sc.setAuthentication(auth);

        User user = service.getByEmail(request.getEmail());

        if (!user.isActive()){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = service.loadUserByUsername(user.getEmail());
        String token = jwtTokenUtil.generateToken(userDetails, user.getId());
        user.setJwt(token);

        return new ResponseEntity<>( mapper.map(user, UserResponse.class), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('GUEST', 'HOST', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/logout")
    public ResponseEntity logout() {

        Authentication auth = sc.getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)){
            SecurityContextHolder.clearContext();

            return new ResponseEntity<>("You successfully logged out!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("You failed to log out!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping({"/activate"})
    public ResponseEntity<UserResponse> activate(@RequestParam("token") String verificationToken){
        User user = service.activate(verificationToken);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(mapper.map(user, UserResponse.class), HttpStatus.OK);
    }

    @PutMapping("/{userId}/change-password")
    public ResponseEntity<UserResponse> changePassword(@PathVariable Long userId, @RequestBody PasswordChangeRequest request){

        User user = service.changePassword(userId,request);
        if (user != null) {
            UserResponse userResponse = mapper.map(user, UserResponse.class);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping({"/{userId}/toggle-notifications/{notificationType}"})
    public ResponseEntity<UserProfile> toggleNotifications (@PathVariable Long userId, @PathVariable String notificationType){
        return new ResponseEntity<> (mapper.map(service.toggleNotifications(userId, NotificationType.valueOf(notificationType)), UserProfile.class), HttpStatus.OK);
    }

    @PutMapping({"/{userId}/block"})
    public ResponseEntity<UserResponse> blockUser (@PathVariable Long userId){
        return new ResponseEntity<> (mapper.map(service.blockUser(userId), UserResponse.class), HttpStatus.OK);
    }

    @PutMapping({"/{userId}/unblock"})
    public ResponseEntity<UserResponse> unblockUser (@PathVariable Long userId){
        return new ResponseEntity<> (mapper.map(service.unblockUser(userId), UserResponse.class), HttpStatus.OK);
    }

}
