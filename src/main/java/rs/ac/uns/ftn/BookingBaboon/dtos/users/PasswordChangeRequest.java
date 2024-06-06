package rs.ac.uns.ftn.BookingBaboon.dtos.users;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PasswordChangeRequest {
    @Size(min=1, max=64)
    private String currentPassword;

    @Size(min=1, max=64)
    private String newPassword;
}
