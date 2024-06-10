package rs.ac.uns.ftn.BookingBaboon.controllers.users;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Admin;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserCreationKeycloak;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.*;
import rs.ac.uns.ftn.BookingBaboon.helpers.HIBP;
import rs.ac.uns.ftn.BookingBaboon.helpers.PasswordHelper;
import rs.ac.uns.ftn.BookingBaboon.services.KeycloakService;
import rs.ac.uns.ftn.BookingBaboon.services.users.RecaptchaService;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IGuestService;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/guests")
public class GuestController {
    private final IGuestService service;
    private final ModelMapper mapper;
    private final KeycloakService keycloakService;

    @Autowired
    private RecaptchaService recaptchaService;

    @GetMapping
    public ResponseEntity<Collection<GuestResponse>> getGuests() {
        Collection<Guest> guests = service.getAll();
        Collection<GuestResponse> guestResponses =  guests.stream()
                .map(guest -> mapper.map(guest, GuestResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(guestResponses, HttpStatus.OK);
    }

    @GetMapping({"/{guestId}"})
    public ResponseEntity<GuestResponse> get(@PathVariable Long guestId) {
        Guest guest = service.get(guestId);
        if(guest==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( mapper.map(guest, GuestResponse.class), HttpStatus.OK);
    }

    @PostMapping({"/"})
    public ResponseEntity<GuestResponse> create(@RequestBody GuestCreateRequest guest) {
        // check password validity
        if (!PasswordHelper.isValid(guest.getPassword())) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        // run the password against HIBP
        try {
            // TODO: error message?
            if (HIBP.isPasswordBlacklisted(guest.getPassword())) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String token = guest.getRecaptchaToken();
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
            res = keycloakService.registerUser(UserCreationKeycloak.fromGuestCreateRequest(guest), accessToken);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (!res) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        this.service.create(mapper.map(guest, Guest.class));
        return new ResponseEntity<>(mapper.map(guest, GuestResponse.class), HttpStatus.OK);
    }

    @PutMapping({"/"})
    public ResponseEntity<GuestResponse> update(@RequestBody GuestUpdateRequest guest) {
        return new ResponseEntity<>(mapper.map(service.update(mapper.map(guest, Guest.class)),GuestResponse.class),HttpStatus.OK);
    }

    @DeleteMapping({"/{guestId}"})
    public ResponseEntity<GuestResponse> remove(@PathVariable Long guestId) {
        Guest guest = service.remove(guestId);
        if(guest==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( mapper.map(guest,GuestResponse.class), HttpStatus.OK);
    }

    @GetMapping({"/profile/{guestEmail}"})
    public ResponseEntity<GuestProfile> getProfile(@PathVariable String guestEmail) {
        Guest guest = service.getProfile(guestEmail);
        if(guest==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( mapper.map(guest, GuestProfile.class), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('GUEST')")
    @GetMapping({"{guestId}/favorite-accommodations"})
    public ResponseEntity<Collection<AccommodationResponse>> getFavorites(@PathVariable Long guestId){
        Collection<Accommodation> accommodations = service.getFavorites(guestId);

        Collection<AccommodationResponse> accommodationResponses = accommodations.stream()
                .map(accommodation -> mapper.map(accommodation, AccommodationResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(accommodationResponses,HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('GUEST')")
    @PutMapping({"{guestId}/favorite-accommodations/add/{accommodationId}"})
    public ResponseEntity<GuestResponse> addFavorite(@PathVariable Long guestId, @PathVariable Long accommodationId){
        Guest result = service.addFavorite(guestId,accommodationId);
        return new ResponseEntity<>(mapper.map(result,GuestResponse.class),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('GUEST')")
    @PutMapping({"{guestId}/favorite-accommodations/remove/{accommodationId}"})
    public ResponseEntity<GuestResponse> removeFavorite(@PathVariable Long guestId, @PathVariable Long accommodationId){
        Guest result = service.removeFavorite(guestId,accommodationId);
        return new ResponseEntity<>(mapper.map(result,GuestResponse.class),HttpStatus.OK);
    }

    @PutMapping({"/{guestId}/toggle-notifications/{notificationType}"})
    public ResponseEntity<GuestNotificationSettings> toggleNotifications (@PathVariable Long guestId, @PathVariable String notificationType){
        return new ResponseEntity<> (mapper.map(service.toggleNotifications(guestId, NotificationType.valueOf(notificationType)), GuestNotificationSettings.class), HttpStatus.OK);
    }
}
