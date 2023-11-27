package rs.ac.uns.ftn.BookingBaboon.services.notifications;

import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.Notification;

import java.util.Set;

public interface INotificationService {
    Set<Notification> getAll();

    Notification get(Long notificationId) throws ResponseStatusException;

    Notification create(Notification notification) throws ResponseStatusException;

    Notification update(Notification notification) throws ResponseStatusException;

    Notification remove(Long notificationId);

    Set<Notification> getByUserId(Long userId);

    void removeAll();
}
