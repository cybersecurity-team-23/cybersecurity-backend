package rs.ac.uns.ftn.BookingBaboon.services.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.Report;
import rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces.IReportService;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class ReportService implements IReportService {

    @Override
    public Collection<Report> getAll() {
        return null;
    }

    @Override
    public Report get(Long reportId) {
        return null;
    }

    @Override
    public Report create(Report report) {
        return null;
    }

    @Override
    public Report update(Report report) {
        return null;
    }

    @Override
    public Report remove(Report report) {
        return null;
    }
}
