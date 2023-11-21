package rs.ac.uns.ftn.BookingBaboon.controllers.users;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestNotificationSettings;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestProfile;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IGuestService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/guests")
public class GuestController {
    private final IGuestService service;
    private final ModelMapper mapper;

    @GetMapping
    public Collection<Guest> getGuests() {
        return this.service.getAll();
    }

    @GetMapping({"/{guestId}"})
    public GuestResponse get(@PathVariable Long guestId) {
        return mapper.map(service.get(guestId), GuestResponse.class);
    }

    @PostMapping({"/"})
    public GuestResponse create(@RequestBody Guest guest) {
        return mapper.map(service.create(guest), GuestResponse.class);
    }

    @PutMapping({"/"})
    public GuestResponse update(@RequestBody Guest guest) {
        return mapper.map(service.update(guest), GuestResponse.class);
    }

    @DeleteMapping({"/{guestId}"})
    public GuestResponse remove(@PathVariable Long guestId) {
        return mapper.map(service.remove(guestId), GuestResponse.class);
    }

    @GetMapping({"{guestId}/profile"})
    public GuestProfile getProfile(@PathVariable Long guestId){
        return mapper.map(service.getProfile(guestId),GuestProfile.class);
    }

    @GetMapping({"{guestId}/favorite-accommodations"})
    public Collection<Accommodation> getFavorites(@PathVariable Long guestId){
        return service.getFavorites(guestId);
    }

    @PutMapping({"{guestId}/favorite-accommodations/{accommodationId}"})
    public Accommodation addFavorite(@PathVariable Long guestId, @PathVariable Long accommodationId){
        return service.addFavorite(guestId,accommodationId);
    }

    @PutMapping({"/{guestId}/toggle-notifications/{notificationType}"})
    public GuestNotificationSettings toggleNotifications (@PathVariable Long guestId, @PathVariable NotificationType notificationType){
        return mapper.map(service.toggleNotificaitons(guestId, notificationType),GuestNotificationSettings.class);
    }
}
