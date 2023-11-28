package rs.ac.uns.ftn.BookingBaboon.services.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reviews.Review;
import rs.ac.uns.ftn.BookingBaboon.repositories.reviews.IHostReviewRepository;
import rs.ac.uns.ftn.BookingBaboon.repositories.reviews.IReviewRepository;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IReviewService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class ReviewService implements IReviewService {
    private final IReviewRepository reviewRepository;
    @Override
    public Set<Review> getAll() {
        return new HashSet<>();
    }

    @Override
    public Review get(Long reviewId) {
        return new Review();
    }

    @Override
    public Review create(Review review) {
        return new Review();
    }

    @Override
    public Review update(Review review) {
        return new Review();
    }

    @Override
    public Review remove(Long reviewId) {
        return new Review();
    }
}
