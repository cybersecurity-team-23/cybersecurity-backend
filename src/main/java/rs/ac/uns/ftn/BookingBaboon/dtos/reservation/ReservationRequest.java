package rs.ac.uns.ftn.BookingBaboon.dtos.reservation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.TimeSlot;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestResponse;

@Data
public class ReservationRequest {
    @Min(0)
    private Long id;

    @NotNull
    private AccommodationRequest accommodation;

    @NotNull
    private TimeSlot timeSlot;

    @NotNull
    private GuestResponse guest;

    @Min(1)
    private Float price;
}
