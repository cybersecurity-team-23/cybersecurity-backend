package rs.ac.uns.ftn.BookingBaboon.services.users.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.notifications.Notification;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Admin;

import java.util.Collection;

public interface IAdminService {
    Collection<Admin> getAll();

    Admin findAdmin(Long adminId);

    Admin insert(Admin admin);

    Admin update(Admin admin);

    Admin delete(Long adminId);
}
