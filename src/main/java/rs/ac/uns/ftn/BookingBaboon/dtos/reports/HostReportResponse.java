package rs.ac.uns.ftn.BookingBaboon.dtos.reports;

import rs.ac.uns.ftn.BookingBaboon.domain.reports.ReportStatus;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostResponse;

import java.util.Date;

public class HostReportResponse {
    private Long id;
    private UserResponse reportee;
    private Date createdOn;
    private ReportStatus status;
    private String message;
    private HostResponse reportedHost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserResponse getReportee() {
        return reportee;
    }

    public void setReportee(UserResponse reportee) {
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

    public HostResponse getReportedHost() {
        return reportedHost;
    }

    public void setReportedHost(HostResponse reportedHost) {
        this.reportedHost = reportedHost;
    }
}
