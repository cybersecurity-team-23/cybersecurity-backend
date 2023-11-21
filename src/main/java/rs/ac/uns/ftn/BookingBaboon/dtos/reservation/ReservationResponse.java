package rs.ac.uns.ftn.BookingBaboon.dtos.reservation;


import jakarta.persistence.Embedded;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.TimeSlot;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.ReservationStatus;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.AccommodationResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestResponse;

@Data
public class ReservationResponse {
    private Long id;
    private AccommodationResponse accommodation;
    private TimeSlot timeSlot;
    private GuestResponse guest;
    private Float price;
    private ReservationStatus status;
}
