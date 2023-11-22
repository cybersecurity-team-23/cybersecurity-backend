package rs.ac.uns.ftn.BookingBaboon.domain.reports;
import jakarta.persistence.*;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;

@Entity
@Data
@Table(name = "guest_reports")
@TableGenerator(name="guest_report_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="guest_report", valueColumnName="value_pk")

public class GuestReport extends Report {

    @ManyToOne
    private Guest reportedGuest;
}
