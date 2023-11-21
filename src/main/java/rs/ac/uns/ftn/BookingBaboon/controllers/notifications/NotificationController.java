package rs.ac.uns.ftn.BookingBaboon.controllers.notifications;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.Notification;
import rs.ac.uns.ftn.BookingBaboon.dtos.notifications.NotificationResponse;
import rs.ac.uns.ftn.BookingBaboon.services.notifications.INotificationService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/notifications")
public class NotificationController {
    private final INotificationService service;
    private final ModelMapper mapper;

    @GetMapping
    public Collection<Notification> getNotifications() {
        return this.service.getAll();
    }

    @GetMapping({"/{notificationId}"})
    public NotificationResponse get(@PathVariable Long notificationId) {
        return mapper.map(service.get(notificationId),NotificationResponse.class);
    }

    @PostMapping({"/"})
    public NotificationResponse create(@RequestBody Notification notification) {
        return mapper.map(service.create(notification),NotificationResponse.class);
    }

    @PutMapping({"/"})
    public NotificationResponse update(@RequestBody Notification notification) {
        return mapper.map(service.update(notification),NotificationResponse.class);
    }

    @DeleteMapping({"/{notificationId}"})
    public NotificationResponse remove(@PathVariable Long notificationId) {
        return mapper.map(service.remove(notificationId),NotificationResponse.class);
    }

    @GetMapping({"/{userId}"})
    public NotificationResponse getByUserId(@PathVariable Long userId){
        return mapper.map(service.getByUserId(userId),NotificationResponse.class);
    }

}
