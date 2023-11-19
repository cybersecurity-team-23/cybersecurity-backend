package rs.ac.uns.ftn.BookingBaboon.services.users.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.users.User;

import java.util.Collection;

public interface IUserService {
    Collection<User> getAll();

    User findUser(Long userId);

    User insert(User user);

    User update(User user);

    User delete(Long userId);
}
