package rs.ac.uns.ftn.BookingBaboon.services.notifications;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.repositories.notifications.INotificationRepository;

@RequiredArgsConstructor
@Service
public class NotificationService implements INotificationService {

    private final INotificationRepository repository;

}
