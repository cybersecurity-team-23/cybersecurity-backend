package rs.ac.uns.ftn.BookingBaboon.services.reviews;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.reviews.AccommodationReview;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;
import rs.ac.uns.ftn.BookingBaboon.repositories.reviews.IAccommodationReviewRepository;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IAccommodationReviewService;

import java.util.*;

@RequiredArgsConstructor
@Service
public class AccommodationReviewService implements IAccommodationReviewService {

    private final IAccommodationReviewRepository repository;

    ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", LocaleContextHolder.getLocale());
    @Override
    public Collection<AccommodationReview> getAll() {
        return repository.findAll();
    }

    @Override
    public AccommodationReview get(Long accommodationReviewId) {
        Optional<AccommodationReview> found = repository.findById(accommodationReviewId);
        if (found.isEmpty()) {
            String value = bundle.getString("accommodationReview.notFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, value);
        }
        return found.get();
    }

    @Override
    public AccommodationReview create(AccommodationReview accommodationReview) {
        try {
            repository.save(accommodationReview);
            repository.flush();
            return accommodationReview;
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
    public AccommodationReview update(AccommodationReview accommodationReview) {
        try {
            get(accommodationReview.getId()); // this will throw AccommodationReviewNotFoundException if accommodationReview is not found
            repository.save(accommodationReview);
            repository.flush();
            return accommodationReview;
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
    public AccommodationReview remove(Long accommodationReviewId) {
        AccommodationReview found = get(accommodationReviewId);
        repository.delete(found);
        repository.flush();
        return found;
    }

    @Override
    public void removeFromAccommodation(Long accommodationId) {

        for(AccommodationReview review : getAll()) {
            if(review.getReviewedAccommodation().getId().equals(accommodationId)) {
                remove(review.getId());
            }
        }
    }

    @Override
    public User getReviewer(Long accommodationReviewId) {
        Optional<AccommodationReview> found = repository.findById(accommodationReviewId);
        if (found.isEmpty()) {
            String value = bundle.getString("accommodationReview.notFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, value);
        }
        AccommodationReview accommodationReview = found.get();
        return accommodationReview.getReviewer();
    }

    @Override
    public float getAverageRating(Long accommodationId) {

    Collection<AccommodationReview> reviews = getAll();

    int reviewNumber = 0;
    int ratingSum = 0;
    for(AccommodationReview review : reviews) {
        if (review.getReviewedAccommodation().getId().equals(accommodationId)) {
            ratingSum += review.getRating();
            reviewNumber += 1;
        }
    }

    return (float) ratingSum / reviewNumber;
    }

    @Override
    public void removeAllByUser(Long userId) {
        for(AccommodationReview accommodationReview : getAll()) {
            if (accommodationReview.getReviewer().getId().equals(userId)) {
                remove(accommodationReview.getId());
            }
        }
    }

    @Override
    public List<AccommodationReview> getAccommodationReviews(Long accommodationId) {
        return repository.findAccommodationReviewsByReviewedAccommodation_Id(accommodationId);
    }
}
