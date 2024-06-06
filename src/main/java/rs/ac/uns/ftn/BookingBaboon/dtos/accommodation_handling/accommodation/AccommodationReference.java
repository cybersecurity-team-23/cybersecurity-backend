package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class AccommodationReference {
    @Min(0)
    private Long id;

    public AccommodationReference(){}
    public AccommodationReference(long id) {
        this.id = id;
    }
}
