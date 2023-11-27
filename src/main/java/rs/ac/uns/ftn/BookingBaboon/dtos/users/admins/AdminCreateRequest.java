package rs.ac.uns.ftn.BookingBaboon.dtos.users.admins;

import lombok.Data;

@Data
public class AdminCreateRequest {
    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;
}
