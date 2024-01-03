package rs.ac.uns.ftn.BookingBaboon.repositories.notifications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AvailablePeriod;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.Notification;

import java.util.List;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Long> {
    @Query("SELECT COUNT(notification) FROM Notification notification WHERE notification.user.id = :userId")
    Integer getUnreadCountByUserId(@Param("userId") Long userId);

}
