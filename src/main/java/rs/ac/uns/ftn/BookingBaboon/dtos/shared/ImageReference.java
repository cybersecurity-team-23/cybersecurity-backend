package rs.ac.uns.ftn.BookingBaboon.dtos.shared;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ImageReference {
    @Min(0)
    private Long id;
}
