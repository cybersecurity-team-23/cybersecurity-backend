package rs.ac.uns.ftn.BookingBaboon.dtos.reviews;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ReviewReferenceRequest {
    @Min(0)
    public Long id;
}
