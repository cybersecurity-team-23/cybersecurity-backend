package rs.ac.uns.ftn.BookingBaboon.services.users.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.users.User;

import java.util.Collection;

public interface IUserService {
    Collection<User> getAll();

    User get(Long userId);

    User create(User user);

    User update(User user);

    User remove(Long userId);
}
