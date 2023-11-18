package rs.ac.uns.ftn.BookingBaboon.services.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.repositories.notifications.INotificationRepository;

@Service
public class NotificationService {

    private INotificationRepository repository;

    @Autowired
    public NotificationService(INotificationRepository repository) {
        this.repository = repository;
    }
}
