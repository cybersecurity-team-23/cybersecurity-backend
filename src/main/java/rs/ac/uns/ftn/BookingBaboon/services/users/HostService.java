package rs.ac.uns.ftn.BookingBaboon.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation_handling.Reservation;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IHostRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IHostService;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Service
public class HostService implements IHostService {

    private final IHostRepository repository;

    @Override
    public Collection<Host> getAll() {
        return new ArrayList<Host>();
    }

    @Override
    public Host get(Long hostId) {
        return new Host();
    }

    @Override
    public Host create(Host host) {
        return new Host();
    }

    @Override
    public Host update(Host host) {
        return new Host();
    }

    @Override
    public Host remove(Long hostId) {
        return new Host();
    }

    @Override
    public Host getProfile(Long hostId) {
        return new Host();
    }

    @Override
    public Host toggleNotificaitons(Long hostId, NotificationType notificationType) {
        return new Host();
    }

    @Override
    public Reservation handleReservation(Long reservationId, boolean isApproved) {
        return new Reservation();
    }
}
