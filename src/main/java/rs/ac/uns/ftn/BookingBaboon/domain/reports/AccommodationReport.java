package rs.ac.uns.ftn.BookingBaboon.domain.reports;
import jakarta.persistence.*;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;

@Entity
@Data
@Table(name = "accommodation_reports")
@TableGenerator(name="accommodation_report_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="accommodation_report", valueColumnName="value_pk")

public class AccommodationReport extends Report {

    @ManyToOne
    private Accommodation reportedAccommodation;
}
