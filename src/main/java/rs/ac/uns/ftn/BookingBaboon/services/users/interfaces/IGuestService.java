package rs.ac.uns.ftn.BookingBaboon.services.users.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestNotificationSettings;

import java.util.Collection;

public interface IGuestService {
    Collection<Guest> getAll();

    Guest get(Long guestId);

    Guest create(Guest guest);

    Guest update(Guest guest);

    Guest remove(Long guestId);

    Guest getProfile(Long guestId);

    Collection<Accommodation> getFavorites(Long guestId);

    Accommodation addFavorite(Long guestId, Long accommodationId);

    Guest toggleNotificaitons(Long guestId, NotificationType notificationType);
}
