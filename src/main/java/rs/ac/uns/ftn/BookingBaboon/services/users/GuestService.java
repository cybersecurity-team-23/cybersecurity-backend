package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IGuestRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IGuestService;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class GuestService implements IGuestService {

    private final IGuestRepository repository;

    @Override
    public Collection<Guest> getAll() {
        return null;
    }

    @Override
    public Guest findGuest(Long guestId) {
        return null;
    }

    @Override
    public Guest insert(Guest guest) {
        return null;
    }

    @Override
    public Guest update(Guest guest) {
        return null;
    }

    @Override
    public Guest delete(Long guestId) {
        return null;
    }
}
