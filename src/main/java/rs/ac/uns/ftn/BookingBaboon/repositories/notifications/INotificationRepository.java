package rs.ac.uns.ftn.BookingBaboon.repositories.notifications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.Notification;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Long> {
}
