package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IUserRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IUserService;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final IUserRepository repository;

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public User findUser(Long userId) {
        return null;
    }

    @Override
    public User insert(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User delete(Long userId) {
        return null;
    }
}
