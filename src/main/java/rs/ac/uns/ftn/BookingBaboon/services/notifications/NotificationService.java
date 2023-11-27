package rs.ac.uns.ftn.BookingBaboon.services.notifications;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.Notification;
import rs.ac.uns.ftn.BookingBaboon.repositories.notifications.INotificationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class NotificationService implements INotificationService {

    private final INotificationRepository repository;

    @Override
    public Set<Notification> getAll() {
        return new HashSet<Notification>();
    }

    @Override
    public Notification get(Long notificationId) {
        return new Notification();
    }

    @Override
    public Notification create(Notification notification) {
        return new Notification();
    }

    @Override
    public Notification update(Notification notification) {
        return new Notification();
    }

    @Override
    public Notification remove(Long notificationId) {
        return new Notification();
    }

    @Override
    public Set<Notification> getByUserId(Long userId) {
        return new HashSet<Notification>();
    }
}
