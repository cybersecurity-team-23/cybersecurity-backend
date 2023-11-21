package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Admin;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IAdminRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IAdminService;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Service
public class AdminService implements IAdminService {

    private final IAdminRepository repository;

    @Override
    public Collection<Admin> getAll() {
        return new ArrayList<Admin>();
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
}
