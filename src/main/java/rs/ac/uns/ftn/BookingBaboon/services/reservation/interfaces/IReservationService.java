package rs.ac.uns.ftn.BookingBaboon.services.reservation.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.TimeSlot;

import java.time.Month;
import java.util.Collection;
import java.util.HashSet;

public interface IReservationService {
    public HashSet<Reservation> getAll();
    public Reservation get(Long reservationId);
    public Reservation create(Reservation reservation);
    public Reservation update(Reservation reservation);
    public Reservation remove(Long reservationId);
    public void removeAllForGuest(Long guestId);
    public void removeAll();
    public Reservation deny(Long id);
    public Reservation approveReservation(Long reservationId);
    public int getCancellationCountForUser(Long userId);
    public boolean isApproved(Long reservationId);
    void removeAllForAccommodation(Long accommodationId);
    Collection<Reservation> getAllByAccommodation(Long accommodationId);
    Collection<Reservation> getAllFinishedByAccommodationAndMonth(Long accommodationId, int year, int month);
    Collection<Reservation> getAllFinishedByAccommodationAndTimeSlot(Long accommodationId, TimeSlot timeSlot);
    public Reservation handleAutomaticAcceptance(Reservation reservation);
}
