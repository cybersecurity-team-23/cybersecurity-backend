package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IUserRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IUserService;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final IUserRepository repository;

}
