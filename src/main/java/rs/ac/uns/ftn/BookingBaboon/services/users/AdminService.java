package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IAdminRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IAdminService;

@RequiredArgsConstructor
@Service
public class AdminService implements IAdminService {

    private final IAdminRepository repository;

}
