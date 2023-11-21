package rs.ac.uns.ftn.BookingBaboon.controllers.users;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserProfile;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IUserService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final IUserService service;
    private final ModelMapper mapper;

    @GetMapping
    public Collection<User> getUsers() {
        return this.service.getAll();
    }

    @GetMapping({"/{userId}"})
    public UserResponse get(@PathVariable Long userId) {
        return mapper.map(service.get(userId), UserResponse.class);
    }

    @PostMapping({"/"})
    public UserResponse create(@RequestBody User user) {
        return mapper.map(service.create(user), UserResponse.class);
    }

    @PutMapping({"/"})
    public UserResponse update(@RequestBody User user) {
        return mapper.map(service.update(user), UserResponse.class);
    }

    @DeleteMapping({"/{userId}"})
    public UserResponse remove(@PathVariable Long userId) {
        return mapper.map(service.remove(userId), UserResponse.class);
    }

    @GetMapping({"/profile/{userId}"})
    public UserProfile getProfile(@PathVariable Long userId) {
        return mapper.map(service.get(userId),UserProfile.class);
    }

    @PostMapping({"/login"})
    public UserResponse login(@RequestBody String username, @RequestBody String password){
        return mapper.map(service.login(username,password), UserResponse.class);
    }

    @PutMapping({"{userId}/activate"})
    public UserResponse activate(@PathVariable Long userId){
        return mapper.map(service.activate(userId), UserResponse.class);
    }

    @PutMapping("{userId}/change-password")
    public UserResponse changePassword(@PathVariable Long userId, @RequestBody String password){
        return mapper.map(service.changePassword(userId,password), UserResponse.class);
    }

}
