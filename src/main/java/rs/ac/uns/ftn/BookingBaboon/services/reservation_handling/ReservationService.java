package rs.ac.uns.ftn.BookingBaboon.services.reservation_handling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.repositories.reservation_handling.IReservationRepository;
import rs.ac.uns.ftn.BookingBaboon.services.reservation_handling.interfaces.IReservationService;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    private IReservationRepository reservationRepository;
}
