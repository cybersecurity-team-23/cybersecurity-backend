package rs.ac.uns.ftn.BookingBaboon.services.users.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationChangeRequest;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.GuestReport;
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

    Collection<GuestReport> getAllReports();

    Collection<AccommodationChangeRequest> getAllAccommodationChanges();

    Accommodation approveAccommodationChange(Long accommodationId);

    Accommodation denyAccommodationChange(Long accommodationId);
}
