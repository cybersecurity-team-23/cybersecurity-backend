package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AvailablePeriod;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;
import rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling.IAvailablePeriodRepository;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAvailablePeriodService;

import java.util.*;

@RequiredArgsConstructor
@Service
public class AvailablePeriodService implements IAvailablePeriodService {
    private final IAvailablePeriodRepository availablePeriodRepository;
    ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", LocaleContextHolder.getLocale());

    @Override
    public Collection<AvailablePeriod> getAll() {
        return availablePeriodRepository.findAll();
    }

    @Override
    public AvailablePeriod get(Long availablePeriodId) {
        Optional<AvailablePeriod> found = availablePeriodRepository.findById(availablePeriodId);
        if (found.isEmpty()) {
            String value = bundle.getString("availablePeriod.notFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, value);
        }
        return found.get();
    }

    @Override
    public AvailablePeriod create(AvailablePeriod availablePeriod) {
        try {
            availablePeriodRepository.save(availablePeriod);
            availablePeriodRepository.flush();
            return availablePeriod;
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
    public AvailablePeriod update(AvailablePeriod availablePeriod) {
        try {
            get(availablePeriod.getId()); // this will throw AvailablePeriodNotFoundException if availablePeriod is not found
            availablePeriodRepository.save(availablePeriod);
            availablePeriodRepository.flush();
            return availablePeriod;
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
    public AvailablePeriod remove(Long availablePeriodId) {
        AvailablePeriod found = get(availablePeriodId);
        availablePeriodRepository.delete(found);
        availablePeriodRepository.flush();
        return found;
    }

    @Override
    public void removeAll() {
        availablePeriodRepository.deleteAll();
        availablePeriodRepository.flush();
    }
}
