package rs.ac.uns.ftn.BookingBaboon.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IGuestRepository;

@Service
public class GuestService {
    private IGuestRepository repository;

    @Autowired
    public GuestService(IGuestRepository repository) {
        this.repository = repository;
    }
}
