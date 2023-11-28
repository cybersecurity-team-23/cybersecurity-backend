package rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts;

import lombok.Data;

@Data
public class HostCreateRequest {
    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;
}
