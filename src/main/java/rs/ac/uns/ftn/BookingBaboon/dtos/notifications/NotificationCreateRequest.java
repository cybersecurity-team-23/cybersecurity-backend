package rs.ac.uns.ftn.BookingBaboon.dtos.notifications;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.checkerframework.checker.optional.qual.Present;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserReferenceRequest;

import java.util.Date;

@Data
public class NotificationCreateRequest {
    @Size(min = 1, max = 250)
    @Pattern(regexp = "[a-zA-Z0-9 .,]+")
    private String message;

    @NotNull
    private NotificationType type;

    @NotNull
    private Date timeCreated;

    @NotNull
    private UserReferenceRequest user;
}
