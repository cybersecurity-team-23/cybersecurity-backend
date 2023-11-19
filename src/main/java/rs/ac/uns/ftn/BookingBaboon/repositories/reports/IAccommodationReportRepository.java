package rs.ac.uns.ftn.BookingBaboon.repositories.reports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.AccommodationReport;

@Repository
public interface IAccommodationReportRepository extends JpaRepository<AccommodationReport, Long> {
}
