package rs.ac.uns.ftn.BookingBaboon.dtos.reservation;

import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.TimeSlot;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestResponse;

@Data
public class ReservationCreateRequest {
    private AccommodationReference accommodation;
    private TimeSlot timeSlot;
    private GuestReference guest;
    private Float price;
}
