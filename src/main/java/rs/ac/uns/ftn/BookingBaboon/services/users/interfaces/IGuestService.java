package rs.ac.uns.ftn.BookingBaboon.services.users.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;

import java.util.Collection;

public interface IGuestService {
    Collection<Guest> getAll();

    Guest get(Long guestId);

    Guest create(Guest guest);

    Guest update(Guest guest);

    Guest remove(Long guestId);
}
