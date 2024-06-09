package rs.ac.uns.ftn.BookingBaboon.dtos.users.guests;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class GuestReferenceRequest {
    @Min(0)
    private Long id;
}
