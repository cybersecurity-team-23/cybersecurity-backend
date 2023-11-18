package rs.ac.uns.ftn.BookingBaboon.domain.reports;
import jakarta.persistence.*;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;

@Entity
@Data
@Table(name = "host_reports")
@TableGenerator(name="host_report_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="host_report", valueColumnName="value_pk")

public class HostReport extends Report {

    @ManyToOne
    private Host reportedHost;
}
