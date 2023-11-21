package rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.reviews.AccommodationReview;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;

import java.util.Collection;

public interface IAccommodationReviewService {
    Collection<AccommodationReview> getAll();
    AccommodationReview get(Long hostReviewId);

    AccommodationReview create(AccommodationReview accommodationReview);

    AccommodationReview update(AccommodationReview accommodationReview);

    AccommodationReview remove(Long accommodationReviewId);

    Guest getReviewer(Long id);

    float getAverageRating(Long accommodationId);
}
