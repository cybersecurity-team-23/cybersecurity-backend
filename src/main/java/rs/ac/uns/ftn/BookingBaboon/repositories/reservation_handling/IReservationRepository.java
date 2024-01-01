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

    @Query("SELECT r FROM Reservation r " +
            "WHERE r.accommodation.id = :accommodationId " +
            "AND YEAR(r.timeSlot.startDate) = :year " +
            "AND MONTH(r.timeSlot.startDate) = :month " +
            "AND r.status = :status")
    Collection<Reservation> findAllByAccommodationIdAndMonth(
            @Param("accommodationId") Long accommodationId,
            @Param("year") int year,
            @Param("month") int month,
            @Param("status") ReservationStatus status
    );
}
