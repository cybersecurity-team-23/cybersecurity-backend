package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.available_period;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class AvailablePeriodReference {
    @Min(0)
    private Long id;
}
