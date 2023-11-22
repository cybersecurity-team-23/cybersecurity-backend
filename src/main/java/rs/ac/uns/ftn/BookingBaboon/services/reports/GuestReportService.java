package rs.ac.uns.ftn.BookingBaboon.services.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.GuestReport;
import rs.ac.uns.ftn.BookingBaboon.repositories.reports.IGuestReportRepository;
import rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces.IGuestReportService;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Service
public class GuestReportService implements IGuestReportService {

    private final IGuestReportRepository guestReportRepository;
    @Override
    public Collection<GuestReport> getAll() {
        return new ArrayList<GuestReport>();
    }

    @Override
    public GuestReport get(Long guestReportId) {
        return new GuestReport();
    }

    @Override
    public GuestReport create(GuestReport guestReport) {
        return new GuestReport();
    }

    @Override
    public GuestReport update(GuestReport guestReport) {
        return new GuestReport();
    }

    @Override
    public GuestReport remove(Long guestReportId) {
        return new GuestReport();
    }
}
