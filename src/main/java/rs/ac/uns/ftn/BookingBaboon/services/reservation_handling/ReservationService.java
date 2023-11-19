package rs.ac.uns.ftn.BookingBaboon.services.reservation_handling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation_handling.Reservation;
import rs.ac.uns.ftn.BookingBaboon.repositories.reservation_handling.IReservationRepository;
import rs.ac.uns.ftn.BookingBaboon.services.reservation_handling.interfaces.IReservationService;

import java.util.Collection;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    private IReservationRepository reservationRepository;

    @Override
    public Collection<Reservation> getAll() {
        return null;
    }

    @Override
    public Reservation get(Long reservationId) {
        return null;
    }

    @Override
    public Reservation create(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }

    @Override
    public void remove(Long reservationId) {

    }
}
