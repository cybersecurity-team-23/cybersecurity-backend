package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IHostRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IHostService;

@RequiredArgsConstructor
@Service
public class HostService implements IHostService {

    private final IHostRepository repository;

}
