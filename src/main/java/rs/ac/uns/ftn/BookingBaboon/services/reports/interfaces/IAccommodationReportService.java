package rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.reports.AccommodationReport;

import java.util.Collection;

public interface IAccommodationReportService {
    Collection<AccommodationReport> getAll();
    AccommodationReport get(Long accommodationReportId);

    AccommodationReport create(AccommodationReport accommodationReport);

    AccommodationReport update(AccommodationReport accommodationReport);

    AccommodationReport remove(Long accommodationReportId);
}
