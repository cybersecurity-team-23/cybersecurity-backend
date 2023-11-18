package rs.ac.uns.ftn.BookingBaboon.Domain.Users;

import jakarta.persistence.Entity;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.Domain.Users.User;

@Entity
@Data
public class Guest extends User {
}
