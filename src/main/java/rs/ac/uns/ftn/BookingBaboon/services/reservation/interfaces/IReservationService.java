package rs.ac.uns.ftn.BookingBaboon.services.reservation.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;

import java.util.Collection;

public interface IReservationService {
    public Collection<Reservation> getAll();
    public Reservation get(Long reservationId);
    public Reservation create(Reservation reservation);
    public Reservation update(Reservation reservation);
    public void remove(Long reservationId);
    public Reservation cancel(Long id);
    public int getCancellationCountForUser(Long userId);
}
