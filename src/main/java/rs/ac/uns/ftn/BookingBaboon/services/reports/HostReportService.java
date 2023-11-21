package rs.ac.uns.ftn.BookingBaboon.services.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.HostReport;
import rs.ac.uns.ftn.BookingBaboon.repositories.reports.IHostReportRepository;
import rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces.IHostReportService;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Service
public class HostReportService implements IHostReportService {

    private final IHostReportRepository hostReportRepository;
    @Override
    public Collection<HostReport> getAll() {
        return new ArrayList<HostReport>();
    }

    @Override
    public HostReport get(Long hostReportId) {
        return new HostReport();
    }

    @Override
    public HostReport create(HostReport hostReport) {
        return new HostReport();
    }

    @Override
    public HostReport update(HostReport hostReport) {
        return new HostReport();
    }

    @Override
    public HostReport remove(Long hostReportId) {
        return new HostReport();
    }
}
