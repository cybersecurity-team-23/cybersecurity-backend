package rs.ac.uns.ftn.BookingBaboon.services.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reviews.AccommodationReview;
import rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces.IAccommodationReportService;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IAccommodationReviewService;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class AccommodationReviewService implements IAccommodationReviewService {
    @Override
    public Collection<AccommodationReview> getAll() {
        return null;
    }

    @Override
    public AccommodationReview get(Long hostReviewId) {
        return null;
    }

    @Override
    public AccommodationReview create(AccommodationReview accommodationReview) {
        return null;
    }

    @Override
    public AccommodationReview update(AccommodationReview accommodationReview) {
        return null;
    }

    @Override
    public AccommodationReview remove(AccommodationReview accommodationReview) {
        return null;
    }
}
