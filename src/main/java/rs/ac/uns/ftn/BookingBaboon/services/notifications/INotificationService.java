package rs.ac.uns.ftn.BookingBaboon.services.notifications;

import rs.ac.uns.ftn.BookingBaboon.domain.notifications.Notification;

import java.util.Collection;

public interface INotificationService {
    Collection<Notification> getAll();

    Notification findNotification(Long notificationId);

    Notification insert(Notification notification);

    Notification update(Notification notification);

    Notification delete(Long notificationId);
}
