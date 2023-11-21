package rs.ac.uns.ftn.BookingBaboon.services.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reviews.HostReview;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;
import rs.ac.uns.ftn.BookingBaboon.repositories.reviews.IHostReviewRepository;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IHostReviewService;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Service
public class HostReviewService implements IHostReviewService {
    private final IHostReviewRepository hostReviewRepository;
    @Override
    public Collection<HostReview> getAll() {
        return new ArrayList<HostReview>();
    }

    @Override
    public HostReview get(Long hostReviewId) {
        return new HostReview();
    }

    @Override
    public HostReview create(HostReview hostReview) {
        return new HostReview();
    }

    @Override
    public HostReview update(HostReview hostReview) {
        return new HostReview();
    }

    @Override
    public HostReview remove(Long hostReviewId) {
        return new HostReview();
    }
    @Override
    public Guest getReviewer(Long id) {
        return new Guest();
    }
}
