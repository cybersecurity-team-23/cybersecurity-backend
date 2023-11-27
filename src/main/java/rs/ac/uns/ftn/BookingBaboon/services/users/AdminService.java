package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationModification;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.GuestReport;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Admin;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IAdminRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IAdminService;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AdminService implements IAdminService {

    private final IAdminRepository repository;

    @Override
    public Set<Admin> getAll() {
        return new HashSet<Admin>();
    }

    @Override
    public Admin get(Long adminId) {
        return new Admin();
    }

    @Override
    public Admin create(Admin admin) {
        return new Admin();
    }

    @Override
    public Admin update(Admin admin) {
        return new Admin();
    }

    @Override
    public Admin remove(Long adminId) {
        return new Admin();
    }

    @Override
    public User blockUser(Long userId) {
        return new User();
    }

    @Override
    public Set<GuestReport> getAllReports() {
        return new HashSet<GuestReport>();
    }

    @Override
    public Set<AccommodationModification> getAllAccommodationChanges() {
        return new HashSet<AccommodationModification>();
    }

    @Override
    public Accommodation approveAccommodationChange(Long accommodationId) {
        return new Accommodation();
    }

    @Override
    public Accommodation denyAccommodationChange(Long accommodationId) {
        return new Accommodation();
    }
}
