package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.available_period;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.TimeSlot;

@Data
public class AvailablePeriodRequest {
    @Min(0)
    private Long id;

    @NotNull()
    private TimeSlot timeSlot;

    @Min(1)
    private Float PricePerNight;

    public AvailablePeriodRequest(long id, TimeSlot timeSlot, float pricePerNight) {
        this.id = id;
        this.timeSlot = timeSlot;
        this.PricePerNight = pricePerNight;
    }
}
