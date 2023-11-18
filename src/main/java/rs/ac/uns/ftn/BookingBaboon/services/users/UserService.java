package rs.ac.uns.ftn.BookingBaboon.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IUserRepository;

@Service
public class UserService {
    private IUserRepository repository;

    @Autowired
    public UserService(IUserRepository repository){
        this.repository = repository;
    }
}
