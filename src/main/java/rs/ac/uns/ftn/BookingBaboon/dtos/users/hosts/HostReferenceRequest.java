package rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class HostReferenceRequest {
    @Min(0)
    Long id;
}
