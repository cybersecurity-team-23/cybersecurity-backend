package rs.ac.uns.ftn.BookingBaboon.services.notifications;

import rs.ac.uns.ftn.BookingBaboon.domain.notifications.Notification;

import java.util.Set;

public interface INotificationService {
    Set<Notification> getAll();

    Notification get(Long notificationId);

    Notification create(Notification notification);

    Notification update(Notification notification);

    Notification remove(Long notificationId);

    Set<Notification> getByUserId(Long userId);
}
