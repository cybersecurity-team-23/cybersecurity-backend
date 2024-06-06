package rs.ac.uns.ftn.BookingBaboon.dtos.reports;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.time.DurationMin;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.ReportStatus;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserReferenceRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestReferenceRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostReferenceRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostRequest;

import java.util.Date;

@Data
public class HostReportUpdateRequest {
    @Min(0)
    private Long id;

    @NotNull
    private UserReferenceRequest reportee;

    @NotNull
    private Date createdOn;

    @NotNull
    private ReportStatus status;

    @Size(min = 1, max = 250)
    @Pattern(regexp = "[a-zA-Z0-9 .,]+")
    private String message;

    @NotNull
    private HostReferenceRequest reportedHost;
}
