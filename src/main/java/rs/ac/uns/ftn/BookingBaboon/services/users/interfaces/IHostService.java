package rs.ac.uns.ftn.BookingBaboon.services.users.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;

import java.util.Collection;

public interface IHostService {
    Collection<Host> getAll();

    Host get(Long hostId);

    Host create(Host host);

    Host update(Host host);

    Host remove(Long hostId);
}

