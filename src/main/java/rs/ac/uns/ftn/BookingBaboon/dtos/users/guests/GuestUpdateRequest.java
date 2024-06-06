package rs.ac.uns.ftn.BookingBaboon.dtos.users.guests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class GuestUpdateRequest {

    @Min(0)
    private Long id;

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
    private String jwt;
}
