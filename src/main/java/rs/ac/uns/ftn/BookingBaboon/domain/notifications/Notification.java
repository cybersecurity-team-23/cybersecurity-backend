package rs.ac.uns.ftn.BookingBaboon.domain.notifications;

import jakarta.persistence.*;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;

import java.util.Date;

@Entity
@Data
@Table(name = "notifications")
@TableGenerator(name="notifications_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="notification", valueColumnName="value_pk")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "notifications_id_generator")
    private Long id;

    private String message;

    private NotificationType type;

    private Date timeCreated;

    private boolean isRead;

    @ManyToOne
    private User user;
}
