package rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.reviews.AccommodationReview;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;

import java.util.Collection;
import java.util.Set;

public interface IAccommodationReviewService {
    Collection<AccommodationReview> getAll();
    AccommodationReview get(Long hostReviewId);

    AccommodationReview create(AccommodationReview accommodationReview);

    AccommodationReview update(AccommodationReview accommodationReview);

    AccommodationReview remove(Long accommodationReviewId);

    User getReviewer(Long id);

    float getAverageRating(Long accommodationId);
}
