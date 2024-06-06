package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.available_period;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.TimeSlot;

@Data
public class AvailablePeriodCreateRequest{
        @NotNull
        private TimeSlot timeSlot;

        @Min(1)
        private Float PricePerNight;

        public AvailablePeriodCreateRequest(TimeSlot timeSlot, float pricePerNight) {
                this.timeSlot = timeSlot;
                this.PricePerNight = pricePerNight;
        }
}
