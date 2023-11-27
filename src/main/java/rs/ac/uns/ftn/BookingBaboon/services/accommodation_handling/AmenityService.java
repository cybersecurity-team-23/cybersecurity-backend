package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Amenity;
import rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling.IAmenityRepository;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAmenityService;

import java.util.*;

@RequiredArgsConstructor
@Service
public class AmenityService implements IAmenityService {
    private final IAmenityRepository amenityRepository;
    ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", LocaleContextHolder.getLocale());
    @Override
    public Collection<Amenity> getAll() {
        return amenityRepository.findAll();
    }

    @Override
    public Amenity get(Long amenityId) {
        Optional<Amenity> found = amenityRepository.findById(amenityId);
        if (found.isEmpty()) {
            String value = bundle.getString("amenity.notFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, value);
        }
        return found.get();
    }

    @Override
    public Amenity create(Amenity reservation) {
        try {
            amenityRepository.save(reservation);
            amenityRepository.flush();
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
    public Amenity update(Amenity reservation) {
        try {
            get(reservation.getId()); // this will throw AmenityNotFoundException if reservation is not found
            amenityRepository.save(reservation);
            amenityRepository.flush();
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
    public Amenity remove(Long amenityId) {
        Amenity found = get(amenityId);
        amenityRepository.delete(found);
        amenityRepository.flush();
        return found;
    }

    @Override
    public void removeAll() {
        amenityRepository.deleteAll();
        amenityRepository.flush();
    }
}
