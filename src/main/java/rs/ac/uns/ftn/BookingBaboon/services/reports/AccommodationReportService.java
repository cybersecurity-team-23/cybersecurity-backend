package rs.ac.uns.ftn.BookingBaboon.services.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.AccommodationReport;
import rs.ac.uns.ftn.BookingBaboon.repositories.reports.IAccommodationReportRepository;
import rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces.IAccommodationReportService;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Service
public class AccommodationReportService implements IAccommodationReportService {

    private final IAccommodationReportRepository accommodationReportRepository;
    @Override
    public Collection<AccommodationReport> getAll() {
        return new ArrayList<AccommodationReport>();
    }

    @Override
    public AccommodationReport get(Long accommodationReportId) {
        return new AccommodationReport();
    }

    @Override
    public AccommodationReport create(AccommodationReport accommodationReport) {
        return new AccommodationReport();
    }

    @Override
    public AccommodationReport update(AccommodationReport accommodationReport) {
        return new AccommodationReport();
    }

    @Override
    public AccommodationReport remove(Long accommodationReportId) {
        return new AccommodationReport();
    }
}
