package rs.ac.uns.ftn.BookingBaboon.services.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reviews.AccommodationReview;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.repositories.reviews.IAccommodationReviewRepository;
import rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces.IAccommodationReportService;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IAccommodationReviewService;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Service
public class AccommodationReviewService implements IAccommodationReviewService {

    private final IAccommodationReviewRepository accommodationReviewRepository;
    @Override
    public Collection<AccommodationReview> getAll() {
        return new ArrayList<AccommodationReview>();
    }

    @Override
    public AccommodationReview get(Long hostReviewId) {
        return new AccommodationReview();
    }

    @Override
    public AccommodationReview create(AccommodationReview accommodationReview) {
        return new AccommodationReview();
    }

    @Override
    public AccommodationReview update(AccommodationReview accommodationReview) {
        return new AccommodationReview();
    }

    @Override
    public AccommodationReview remove(Long accommodationReviewId) {
        return new AccommodationReview();
    }

    @Override
    public Guest getReviewer(Long id) {
        return new Guest();
    }

    @Override
    public float getAverageRating(Long accommodationId) {
        return 0;
    }
}
