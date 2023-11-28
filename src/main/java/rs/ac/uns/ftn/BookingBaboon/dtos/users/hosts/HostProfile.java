package rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts;

import lombok.Data;

@Data
public class HostProfile {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;
}
