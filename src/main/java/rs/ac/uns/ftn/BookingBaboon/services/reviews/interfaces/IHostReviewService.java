package rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.reviews.HostReview;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;

import java.util.Collection;
import java.util.Set;

public interface IHostReviewService {

    Collection<HostReview> getAll();

    HostReview get(Long hostReviewId);

    HostReview create(HostReview hostReview);

    HostReview update(HostReview hostReview);

    HostReview remove(Long hostReviewid);

    User getReviewer(Long id);

    float getAverageRating(Long id);
}
