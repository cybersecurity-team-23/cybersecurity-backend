package rs.ac.uns.ftn.BookingBaboon.dtos.users;

import lombok.Data;

@Data
public class UserCreateRequest {

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

}
