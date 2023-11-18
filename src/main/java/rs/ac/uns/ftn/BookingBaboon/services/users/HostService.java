package rs.ac.uns.ftn.BookingBaboon.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IHostRepository;

@Service
public class HostService {

    private IHostRepository repository;

    @Autowired
    public HostService(IHostRepository repository) {
        this.repository = repository;
    }
}
