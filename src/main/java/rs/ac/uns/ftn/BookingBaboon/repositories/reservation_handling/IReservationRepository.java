package rs.ac.uns.ftn.BookingBaboon.repositories.reservation_handling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;

import java.util.Collection;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {
    Collection<Reservation> findAllByAccommodationId(Long accommodationId);
    Collection<Reservation> findAllByGuest_Id(Long guest_id);
}
