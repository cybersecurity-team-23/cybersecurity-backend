package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IHostRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IHostService;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class HostService implements IHostService {

    private final IHostRepository repository;

    @Override
    public Collection<Host> getAll() {
        return null;
    }

    @Override
    public Host findHost(Long hostId) {
        return null;
    }

    @Override
    public Host insert(Host host) {
        return null;
    }

    @Override
    public Host update(Host host) {
        return null;
    }

    @Override
    public Host delete(Long hostId) {
        return null;
    }
}
