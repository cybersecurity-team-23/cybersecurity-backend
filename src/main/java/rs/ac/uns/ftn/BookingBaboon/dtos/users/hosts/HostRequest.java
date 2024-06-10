package rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class HostRequest {
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
}
