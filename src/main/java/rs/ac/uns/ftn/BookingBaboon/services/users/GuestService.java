package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestNotificationSettings;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IGuestRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IGuestService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class GuestService implements IGuestService {

    private final IGuestRepository repository;

    @Override
    public Set<Guest> getAll() {
        return new HashSet<Guest>();
    }

    @Override
    public Guest get(Long guestId) {
        return new Guest();
    }

    @Override
    public Guest create(Guest guest) {
        return new Guest();
    }

    @Override
    public Guest update(Guest guest) {
        return new Guest();
    }

    @Override
    public Guest remove(Long guestId) {
        return new Guest();
    }

    @Override
    public Guest getProfile(Long guestId) {
        return new Guest();
    }

    @Override
    public Set<Accommodation> getFavorites(Long guestId) {
        return new HashSet<Accommodation>();
    }

    @Override
    public Accommodation addFavorite(Long guestId, Long accommodationId) {
        return new Accommodation();
    }

    @Override
    public Guest toggleNotificaitons(Long guestId, NotificationType notificationType) {
        return new Guest();
    }
}
