package rs.ac.uns.ftn.BookingBaboon.repositories.notifications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AvailablePeriod;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.Notification;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;

import java.util.Collection;
import java.util.List;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Long> {
    Integer countByUserIdAndIsReadFalse(@Param("userId") Long userId);

    @Query("SELECT COUNT(n) FROM Notification n WHERE n.id = :userId AND n.isRead = false AND n.type != :type")
    Integer countUnreadByUserIdAndNotType(@Param("userId") Long userId, @Param("type") NotificationType type);
    Collection<Notification> findAllByUserIdAndTypeNot(Long userId, NotificationType type);
}
