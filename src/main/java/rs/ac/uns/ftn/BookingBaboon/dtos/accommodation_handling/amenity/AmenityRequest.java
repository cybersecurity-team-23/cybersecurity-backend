package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.amenity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AmenityRequest {
    @Min(0)
    private Long id;

    @Size(min = 1, max = 50)
    @Pattern(regexp = "[a-zA-Z0-9 ]+")
    private String name;
}
