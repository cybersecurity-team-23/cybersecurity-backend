package rs.ac.uns.ftn.BookingBaboon.services.users.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;

import java.util.Collection;

public interface IGuestService {
    Collection<Guest> getAll();

    Guest findGuest(Long guestId);

    Guest insert(Guest guest);

    Guest update(Guest guest);

    Guest delete(Long guestId);
}
