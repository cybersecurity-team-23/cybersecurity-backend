package rs.ac.uns.ftn.BookingBaboon.dtos.users.guests;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class GuestRequest {
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
}
