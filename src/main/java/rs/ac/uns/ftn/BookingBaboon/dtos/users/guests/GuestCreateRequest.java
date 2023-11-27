package rs.ac.uns.ftn.BookingBaboon.dtos.users.guests;

import lombok.Data;

@Data
public class GuestCreateRequest {
    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;
}
