package rs.ac.uns.ftn.BookingBaboon.dtos.reports;

import rs.ac.uns.ftn.BookingBaboon.domain.reports.ReportStatus;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostRequest;

import java.util.Date;

public class HostReportRequest {
    private Long id;
    private UserRequest reportee;
    private Date createdOn;
    private ReportStatus status;
    private String message;
    private HostRequest reportedHost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRequest getReportee() {
        return reportee;
    }

    public void setReportee(UserRequest reportee) {
        this.reportee = reportee;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HostRequest getReportedHost() {
        return reportedHost;
    }

    public void setReportedHost(HostRequest reportedHost) {
        this.reportedHost = reportedHost;
    }
}
