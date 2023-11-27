package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationChangeRequest;
import rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling.IAccommodationChangeRequestRepository;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationChangeRequestService;

import java.util.*;

@RequiredArgsConstructor
@Service
public class AccommodationChangeRequestService implements IAccommodationChangeRequestService {
    private final IAccommodationChangeRequestRepository repository;

    ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", LocaleContextHolder.getLocale());

    @Override
    public HashSet<AccommodationChangeRequest> getAll() {
        return new HashSet<AccommodationChangeRequest>(repository.findAll());
    }

    @Override
    public AccommodationChangeRequest get(Long requestId) {
        Optional<AccommodationChangeRequest> found = repository.findById(requestId);
        if (found.isEmpty()) {
            String value = bundle.getString("accommodationChangeRequest.notFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, value);
        }
        return found.get();
    }

    @Override
    public AccommodationChangeRequest create(AccommodationChangeRequest reservation) {
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
    public AccommodationChangeRequest update(AccommodationChangeRequest reservation) {
        try {
            get(reservation.getId()); // this will throw AccommodationChangeRequestNotFoundException if reservation is not found
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
    public AccommodationChangeRequest remove(Long requestId) {
        AccommodationChangeRequest found = get(requestId);
        repository.delete(found);
        repository.flush();
        return found;
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
        repository.flush();
    }


}
