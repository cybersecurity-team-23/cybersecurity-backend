package rs.ac.uns.ftn.BookingBaboon.dtos.notifications;

import lombok.Data;

import java.util.Date;

@Data
public class NotificationResponse {

    private Long id;

    private String message;

    private boolean isRead;

    private Date timeCreated;

}
