package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling;

import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationMonthlySummary;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.PeriodSummary;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.ISummaryService;

import java.util.Date;

@Service
public class SummaryService implements ISummaryService {
    @Override
    public PeriodSummary getPeriodSummary(String hostId, Date startDate, Date endDate) {
        return null;
    }

    @Override
    public AccommodationMonthlySummary getMonthlySummary(Long id) {
        return null;
    }
}
