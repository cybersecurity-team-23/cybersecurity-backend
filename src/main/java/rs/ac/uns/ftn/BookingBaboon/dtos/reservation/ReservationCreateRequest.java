package rs.ac.uns.ftn.BookingBaboon.dtos.reservation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.TimeSlot;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestReference;

@Data
public class ReservationCreateRequest {
    @NotNull
    private AccommodationReference accommodation;

    @NotNull
    private TimeSlot timeSlot;

    @NotNull

    @Min(1)
    private GuestReference guest;
    private Float price;

    public ReservationCreateRequest(AccommodationReference accommodationReference, TimeSlot timeSlot, GuestReference guestReference, Float price) {
        this.accommodation = accommodationReference;
        this.timeSlot = timeSlot;
        this.guest = guestReference;
        this.price = price;
    }
}
