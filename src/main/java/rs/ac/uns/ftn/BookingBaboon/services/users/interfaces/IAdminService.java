package rs.ac.uns.ftn.BookingBaboon.services.users.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.users.Admin;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;

import java.util.Collection;

public interface IAdminService {
    Collection<Admin> getAll();

    Admin get(Long adminId);

    Admin create(Admin admin);

    Admin update(Admin admin);

    Admin remove(Long adminId);

    User blockUser(Long userId);
}
