package rs.ac.uns.ftn.BookingBaboon.dtos.reservation;


import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.TimeSlot;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.ReservationStatus;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestResponse;

@Data
public class ReservationResponse {
    private Long id;
    private AccommodationReference accommodation;
    private TimeSlot timeSlot;
    private GuestReference guest;
    private Float price;
    private ReservationStatus status;
}
