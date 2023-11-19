package rs.ac.uns.ftn.BookingBaboon.services.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reviews.Review;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IReviewService;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class ReviewService implements IReviewService {
    @Override
    public Collection<Review> getAll() {
        return null;
    }

    @Override
    public Review get(Long reviewId) {
        return null;
    }

    @Override
    public Review create(Review review) {
        return null;
    }

    @Override
    public Review update(Review review) {
        return null;
    }

    @Override
    public Review remove(Review review) {
        return null;
    }
}
