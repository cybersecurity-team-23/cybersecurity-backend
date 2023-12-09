package rs.ac.uns.ftn.BookingBaboon.dtos.reservation;


import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.TimeSlot;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.ReservationStatus;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationResponse;
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
