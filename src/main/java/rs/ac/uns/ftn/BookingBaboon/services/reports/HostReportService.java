package rs.ac.uns.ftn.BookingBaboon.services.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.HostReport;
import rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces.IHostReportService;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class HostReportService implements IHostReportService {
    @Override
    public Collection<HostReport> getAll() {
        return null;
    }

    @Override
    public HostReport get(Long hostReportId) {
        return null;
    }

    @Override
    public HostReport create(HostReport hostReport) {
        return null;
    }

    @Override
    public HostReport update(HostReport hostReport) {
        return null;
    }

    @Override
    public HostReport remove(HostReport hostReport) {
        return null;
    }
}
