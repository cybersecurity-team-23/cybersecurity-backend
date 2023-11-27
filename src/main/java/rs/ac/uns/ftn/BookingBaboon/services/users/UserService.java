package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IUserRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IUserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final IUserRepository repository;

    @Override
    public Set<User> getAll() {
        return new HashSet<User>();
    }

    @Override
    public User get(Long userId) {
        return new User();
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return new User();
    }

    @Override
    public User remove(Long userId) {
        return new User();
    }

    @Override
    public User login(String email, String password) {
        return new User();
    }

    @Override
    public User activate(Long userId) {
        return new User();
    }

    @Override
    public User changePassword(Long userId, String password) {
        return new User();
    }
}
