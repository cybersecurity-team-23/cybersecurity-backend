package rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class HostReference {
    @Min(0)
    private Long id;
}
