package rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.reviews.HostReview;

import java.util.Collection;

public interface IHostReviewService {

    Collection<HostReview> getAll();

    HostReview get(Long hostReviewId);

    HostReview create(HostReview hostReview);

    HostReview update(HostReview hostReview);

    HostReview remove(HostReview hostReview);
}
