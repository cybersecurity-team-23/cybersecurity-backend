package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IGuestRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IGuestService;

@RequiredArgsConstructor
@Service
public class GuestService implements IGuestService {

    private final IGuestRepository repository;

}
