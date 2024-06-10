package rs.ac.uns.ftn.BookingBaboon.dtos.users.guests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Role;

@Data
public class GuestCreateRequest {
    @Size(min=1, max=64)
    private String password;

    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @Pattern(regexp = "[a-zA-Z]+")
    @Size(min = 1,  max = 50)
    private String firstName;

    @Pattern(regexp = "[a-zA-Z]+")
    @Size(min = 1,  max = 50)
    private String lastName;

    @Pattern(regexp = "[A-Za-z0-9 .,]+")
    @Size(min = 1,  max = 100)
    private String address;

    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$")
    private String phoneNumber;

    @NotNull
    private Role role;

    @NotNull
    private String recaptchaToken;
}
