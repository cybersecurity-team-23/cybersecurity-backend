package rs.ac.uns.ftn.BookingBaboon.dtos.users.guests;

import lombok.Data;

@Data
public class GuestProfile {

    private Long id;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

}
