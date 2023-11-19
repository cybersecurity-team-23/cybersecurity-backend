package rs.ac.uns.ftn.BookingBaboon.services.users.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;

import java.util.Collection;

public interface IHostService {
    Collection<Host> getAll();

    Host findHost(Long hostId);

    Host insert(Host host);

    Host update(Host host);

    Host delete(Long hostId);
}

