package rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;

import java.util.Set;

@Data
public class HostNotificationSettings {

    @Min(0)
    private Long id;

    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;


}
