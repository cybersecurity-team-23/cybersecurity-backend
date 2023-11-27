package rs.ac.uns.ftn.BookingBaboon.controllers.users;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.*;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IGuestService;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/guests")
public class GuestController {
    private final IGuestService service;
    private final ModelMapper mapper;

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
        return new ResponseEntity<>(mapper.map(service.create(mapper.map(guest, Guest.class)),GuestResponse.class), HttpStatus.CREATED);
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

    @GetMapping({"/profile/{guestId}"})
    public ResponseEntity<GuestProfile> getProfile(@PathVariable Long guestId) {
        Guest guest = service.get(guestId);
        if(guest==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( mapper.map(guest, GuestProfile.class), HttpStatus.OK);
    }

    @GetMapping({"{guestId}/favorite-accommodations"})
    public ResponseEntity<Collection<AccommodationResponse>> getFavorites(@PathVariable Long guestId){
        Collection<Accommodation> accommodations = service.getFavorites(guestId);

        Collection<AccommodationResponse> accommodationResponses = accommodations.stream()
                .map(accommodation -> mapper.map(accommodation, AccommodationResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(accommodationResponses,HttpStatus.OK);
    }

    @PutMapping({"{guestId}/favorite-accommodations/{accommodationId}"})
    public ResponseEntity<AccommodationResponse> addFavorite(@PathVariable Long guestId, @PathVariable Long accommodationId){
        return new ResponseEntity<>(mapper.map(service.addFavorite(guestId,accommodationId),AccommodationResponse.class),HttpStatus.OK);
    }

    @PutMapping({"/{guestId}/toggle-notifications/{notificationType}"})
    public ResponseEntity<GuestNotificationSettings> toggleNotifications (@PathVariable Long guestId, @PathVariable NotificationType notificationType){
        return new ResponseEntity<> (mapper.map(service.toggleNotifications(guestId, notificationType), GuestNotificationSettings.class), HttpStatus.OK);
    }
}
