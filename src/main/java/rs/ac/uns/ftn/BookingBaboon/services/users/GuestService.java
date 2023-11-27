package rs.ac.uns.ftn.BookingBaboon.services.users;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestNotificationSettings;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IGuestRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IGuestService;

import java.util.*;

@RequiredArgsConstructor
@Service
public class GuestService implements IGuestService {

    private final IGuestRepository repository;

    ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", LocaleContextHolder.getLocale());


    @Override
    public Set<Guest> getAll() {
        return new HashSet<Guest>(repository.findAll());
    }

    @Override
    public Guest get(Long guestId) throws ResponseStatusException{
        Optional<Guest> found = repository.findById(guestId);
        if (found.isEmpty()) {
            String value = bundle.getString("guest.notFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, value);
        }
        return found.get();
    }

    @Override
    public Guest create(Guest guest) throws ResponseStatusException{
        try {
            repository.save(guest);
            repository.flush();
            return guest;
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
    public Guest update(Guest guest) throws ResponseStatusException{
        try {
            get(guest.getId());
            repository.save(guest);
            repository.flush();
            return guest;
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
    public Guest remove(Long guestId) {
        Guest found = get(guestId);
        repository.delete(found);
        repository.flush();
        return found;
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
        repository.flush();
    }

    @Override
    public Guest getProfile(Long guestId) {
        return new Guest();
    }

    @Override
    public Set<Accommodation> getFavorites(Long guestId) {
        return new HashSet<Accommodation>();
    }

    @Override
    public Accommodation addFavorite(Long guestId, Long accommodationId) {
        return new Accommodation();
    }

    @Override
    public Guest toggleNotifications(Long guestId, NotificationType notificationType) {
        return new Guest();
    }


}
