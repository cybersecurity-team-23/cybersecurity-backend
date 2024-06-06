package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.amenity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AmenityReference {
    @Min(0)
    private Long id;
}
