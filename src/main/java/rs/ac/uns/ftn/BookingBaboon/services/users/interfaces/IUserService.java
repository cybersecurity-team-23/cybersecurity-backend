package rs.ac.uns.ftn.BookingBaboon.services.users.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.tokens.EmailVerificationToken;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;

import java.util.Collection;

public interface IUserService{
    Collection<User> getAll();

    User get(Long userId) throws ResponseStatusException;

    User create(User user) throws ResponseStatusException;

    User update(User user) throws ResponseStatusException;

    User remove(Long userId);

    User login(String username, String password);

    User activate(String verificationToken);

    User changePassword(Long userId, String password);

    void removeAll();

    User getByEmail(String email);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
