package rs.ac.uns.ftn.BookingBaboon.services.reservation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.ReservationStatus;
import rs.ac.uns.ftn.BookingBaboon.repositories.reservation_handling.IReservationRepository;
import rs.ac.uns.ftn.BookingBaboon.services.reservation.interfaces.IReservationService;

import java.util.*;
@RequiredArgsConstructor
@Service
public class ReservationService implements IReservationService {
    private final IReservationRepository repository;

    ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", LocaleContextHolder.getLocale());

    @Override
    public HashSet<Reservation> getAll() {
        return new HashSet<Reservation>(repository.findAll());
    }

    @Override
    public Reservation get(Long reservationId) {
        Optional<Reservation> found = repository.findById(reservationId);
        if (found.isEmpty()) {
            String value = bundle.getString("reservation.notFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, value);
        }
        return found.get();
    }

    @Override
    public Reservation create(Reservation reservation) {
        try {
            repository.save(reservation);
            repository.flush();
            return reservation;
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
    public Reservation update(Reservation reservation) {
        try {
            get(reservation.getId()); // this will throw ReservationNotFoundException if reservation is not found
            repository.save(reservation);
            repository.flush();
            return reservation;
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
    public Reservation remove(Long reservationId) {
        Reservation found = get(reservationId);
        repository.delete(found);
        repository.flush();
        return found;
    }

    @Override
    public void removeAllForGuest(Long guestId) {
        for(Reservation reservation : getAll()) {
            if (reservation.getGuest().getId().equals(guestId)) {
                remove(reservation.getId());
            }
        }
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
        repository.flush();
    }
    @Override
    public Reservation cancel(Long reservationId) {
        Reservation found = get(reservationId);
        found.Cancel();
        update(found);
        return found;
    }

    @Override
    public int getCancellationCountForUser(Long userId) {
        return 0;
    }

    @Override
    public boolean isApproved(Long reservationId) {
        return get(reservationId).getStatus().equals(ReservationStatus.Approved);
    }
}
