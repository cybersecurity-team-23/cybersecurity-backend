package rs.ac.uns.ftn.BookingBaboon.services.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.AccommodationReport;
import rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces.IAccommodationReportService;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class AccommodationReportService implements IAccommodationReportService {
    @Override
    public Collection<AccommodationReport> getAll() {
        return null;
    }

    @Override
    public AccommodationReport get(Long accommodationReportId) {
        return null;
    }

    @Override
    public AccommodationReport create(AccommodationReport accommodationReport) {
        return null;
    }

    @Override
    public AccommodationReport update(AccommodationReport accommodationReport) {
        return null;
    }

    @Override
    public AccommodationReport remove(AccommodationReport accommodationReport) {
        return null;
    }
}
