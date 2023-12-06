package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling.IAccommodationRepository;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationService;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IAccommodationReviewService;

import java.util.*;

@RequiredArgsConstructor
@Service
public class AccommodationService implements IAccommodationService {
    private final IAccommodationRepository repository;
    private final IAccommodationReviewService accommodationReviewService;
    ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", LocaleContextHolder.getLocale());

    @Override
    public HashSet<Accommodation> getAll() {
        return new HashSet<Accommodation>(repository.findAll());
    }

    @Override
    public HashSet<Accommodation> getAllByHost(Long hostId) {
        HashSet<Accommodation> accommodations = getAll();
        HashSet<Accommodation> accommodationsByHost = new HashSet<>();
        for(Accommodation accommodation : accommodations) {
            if (accommodation.getHost().getId().equals(hostId)) {
                accommodationsByHost.add(accommodation);
            }
        }
        return accommodationsByHost;
    }

    @Override
    public Accommodation get(Long accommodationId) {
        Optional<Accommodation> found = repository.findById(accommodationId);
        if (found.isEmpty()) {
            String value = bundle.getString("accommodation.notFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, value);
        }
        return found.get();
    }

    @Override
    public Accommodation create(Accommodation accommodation) {
        try {
            repository.save(accommodation);
            repository.flush();
            return accommodation;
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
    public Accommodation update(Accommodation accommodation) {
        try {
            get(accommodation.getId()); // this will throw AccommodationNotFoundException if accommodation is not found
            repository.save(accommodation);
            repository.flush();
            return accommodation;
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
    public Accommodation remove(Long accommodationId) {
        Accommodation found = get(accommodationId);
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
    public void removeAllByHost(Long hostId) {
        for(Accommodation accommodation : getAllByHost(hostId)) {
            accommodationReviewService.removeFromAccommodation(accommodation.getId());
            repository.delete(accommodation);
            repository.flush();
        }
    }

}
