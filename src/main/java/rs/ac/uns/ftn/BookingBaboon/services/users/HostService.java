package rs.ac.uns.ftn.BookingBaboon.services.users;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IHostRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IHostService;

import java.util.*;

@RequiredArgsConstructor
@Service
public class HostService implements IHostService {

    private final IHostRepository repository;

    ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", LocaleContextHolder.getLocale());

    @Override
    public Set<Host> getAll() {
        return new HashSet<Host>(repository.findAll());
    }

    @Override
    public Host get(Long hostId) throws ResponseStatusException {
        Optional<Host> found = repository.findById(hostId);
        if (found.isEmpty()) {
            String value = bundle.getString("host.notFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, value);
        }
        return found.get();    }

    @Override
    public Host create(Host host) throws ResponseStatusException {
        try {
            repository.save(host);
            repository.flush();
            return host;
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
    public Host update(Host host) throws ResponseStatusException {
        try {
            get(host.getId());
            repository.save(host);
            repository.flush();
            return host;
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
    public Host remove(Long hostId) {
        Host found = get(hostId);
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
    public Host getProfile(Long hostId) {
        return new Host();
    }

    @Override
    public Host toggleNotificaitons(Long hostId, NotificationType notificationType) {
        return new Host();
    }

    @Override
    public Reservation handleReservation(Long reservationId, boolean isApproved) {
        return new Reservation();
    }


}
