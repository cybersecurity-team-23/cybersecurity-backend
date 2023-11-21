package rs.ac.uns.ftn.BookingBaboon.repositories.reservation_handling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}
