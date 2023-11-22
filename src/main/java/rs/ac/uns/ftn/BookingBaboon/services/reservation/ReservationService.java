package rs.ac.uns.ftn.BookingBaboon.services.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;
import rs.ac.uns.ftn.BookingBaboon.repositories.reservation_handling.IReservationRepository;
import rs.ac.uns.ftn.BookingBaboon.services.reservation.interfaces.IReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    private IReservationRepository reservationRepository;

    @Override
    public Collection<Reservation> getAll() {
        return new ArrayList<Reservation>();
    }

    @Override
    public Reservation get(Long reservationId) {
        return new Reservation();
    }

    @Override
    public Reservation create(Reservation reservation) {
        return new Reservation();
    }

    @Override
    public Reservation update(Reservation reservation) {
        return new Reservation();
    }

    @Override
    public void remove(Long reservationId) {}
    @Override
    public Reservation cancel(Long id) {
        return new Reservation();
    }

    @Override
    public int getCancellationCountForUser(Long userId) {
        return 0;
    }
}
