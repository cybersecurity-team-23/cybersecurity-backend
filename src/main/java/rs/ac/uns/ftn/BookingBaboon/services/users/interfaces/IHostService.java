package rs.ac.uns.ftn.BookingBaboon.services.users.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;

import java.util.Collection;

public interface IHostService {
    Collection<Host> getAll();

    Host get(Long hostId);

    Host create(Host host);

    Host update(Host host);

    Host remove(Long hostId);

    Host getProfile(Long hostId);

    Host toggleNotificaitons(Long hostId, NotificationType notificationType);

    Reservation handleReservation(Long reservationId, boolean isApproved);
}

