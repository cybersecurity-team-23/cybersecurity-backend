package rs.ac.uns.ftn.BookingBaboon.services.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reviews.HostReview;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IHostReviewService;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class HostReviewService implements IHostReviewService {
    @Override
    public Collection<HostReview> getAll() {
        return null;
    }

    @Override
    public HostReview get(Long hostReviewId) {
        return null;
    }

    @Override
    public HostReview create(HostReview hostReview) {
        return null;
    }

    @Override
    public HostReview update(HostReview hostReview) {
        return null;
    }

    @Override
    public HostReview remove(HostReview hostReview) {
        return null;
    }
}
