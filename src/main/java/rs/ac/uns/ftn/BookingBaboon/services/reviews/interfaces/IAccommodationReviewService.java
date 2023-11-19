package rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.reviews.AccommodationReview;

import java.util.Collection;

public interface IAccommodationReviewService {
    Collection<AccommodationReview> getAll();
    AccommodationReview get(Long hostReviewId);

    AccommodationReview create(AccommodationReview accommodationReview);

    AccommodationReview update(AccommodationReview accommodationReview);

    AccommodationReview remove(AccommodationReview accommodationReview);
}
