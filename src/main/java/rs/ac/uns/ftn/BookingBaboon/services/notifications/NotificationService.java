package rs.ac.uns.ftn.BookingBaboon.services.notifications;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.Notification;
import rs.ac.uns.ftn.BookingBaboon.repositories.notifications.INotificationRepository;

import java.util.*;

@RequiredArgsConstructor
@Service
public class NotificationService implements INotificationService {

    private final INotificationRepository repository;

    ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", LocaleContextHolder.getLocale());

    @Override
    public Collection<Notification> getAll() {
        return new ArrayList<Notification>(repository.findAll());
    }

    @Override
    public Notification get(Long notificationId) throws ResponseStatusException{
        Optional<Notification> found = repository.findById(notificationId);
        if (found.isEmpty()) {
            String value = bundle.getString("notification.notFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, value);
        }
        return found.get();
    }

    @Override
    public Notification create(Notification notification) throws ResponseStatusException{
        try {
            repository.save(notification);
            repository.flush();
            return notification;
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> errors = ex.getConstraintViolations();
            StringBuilder sb = new StringBuilder(1000);
            for (ConstraintViolation<?> error : errors) {
                sb.append(error.getMessage()).append("\n");
            }
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, sb.toString());
        }
    }

    @Override
    public Notification update(Notification notification) throws ResponseStatusException {
        try {
            get(notification.getId());
            repository.save(notification);
            repository.flush();
            return notification;
        } catch (RuntimeException ex) {
            Throwable e = ex;
            Throwable c = null;
            while ((e != null) && !((c = e.getCause()) instanceof ConstraintViolationException) ) {
                e = (RuntimeException) c;
            }
            if ((c != null) && (c instanceof ConstraintViolationException)) {
                ConstraintViolationException c2 = (ConstraintViolationException) c;
                Set<ConstraintViolation<?>> errors = c2.getConstraintViolations();
                StringBuilder sb = new StringBuilder(1000);
                for (ConstraintViolation<?> error : errors) {
                    sb.append(error.getMessage() + "\n");
                }
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, sb.toString());
            }
            throw ex;
        }
    }

    @Override
    public Notification remove(Long notificationId) {
        Notification found = get(notificationId);
        repository.delete(found);
        repository.flush();
        return found;
    }

    @Override
    public Collection<Notification> getByUserId(Long userId) {
        return new ArrayList<Notification>();
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
        repository.flush();
    }
}
