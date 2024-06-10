package rs.ac.uns.ftn.BookingBaboon.dtos.notifications;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;

@Data
public class NotificationUpdateRequest {
    @Min(0)
    private Long id;

    @Size(min = 1, max = 250)
    @Pattern(regexp = "[a-zA-Z0-9 .,]+")
    private String message;

    @NotNull
    private NotificationType type;
}
