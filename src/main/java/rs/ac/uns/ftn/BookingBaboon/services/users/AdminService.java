package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Admin;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IAdminRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IAdminService;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class AdminService implements IAdminService {

    private final IAdminRepository repository;

    @Override
    public Collection<Admin> getAll() {
        return null;
    }

    @Override
    public Admin findAdmin(Long adminId) {
        return null;
    }

    @Override
    public Admin insert(Admin admin) {
        return null;
    }

    @Override
    public Admin update(Admin admin) {
        return null;
    }

    @Override
    public Admin delete(Long adminId) {
        return null;
    }
}
