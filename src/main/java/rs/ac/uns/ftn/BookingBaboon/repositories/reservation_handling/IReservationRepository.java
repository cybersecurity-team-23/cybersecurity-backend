package rs.ac.uns.ftn.BookingBaboon.repositories.reservation_handling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.ReservationStatus;

import java.util.Collection;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {
    Collection<Reservation> findAllByAccommodationId(Long accommodationId);
    Collection<Reservation> findAllByGuest_Id(Long guest_id);
    Collection<Reservation> findAllByAccommodation_Host_Id(Long accommodation_host_id);
    @Query("SELECT r FROM Reservation r WHERE r.guest.id = :guest_id AND r.status = :status ")
    Collection<Reservation> findAllByGuest_IdAndStatus( @Param("guest_id") Long guest_id,
                                                        @Param("status") ReservationStatus status);
}
