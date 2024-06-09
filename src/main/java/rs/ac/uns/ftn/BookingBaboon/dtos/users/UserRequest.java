package rs.ac.uns.ftn.BookingBaboon.dtos.users;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserRequest {
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
}
