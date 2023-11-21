package rs.ac.uns.ftn.BookingBaboon.dtos.reports;

import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.ReportStatus;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.AccommodationRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserRequest;

import java.util.Date;

public class AccommodationReportRequest {
    private Long id;
    private UserRequest reportee;
    private Date createdOn;
    private ReportStatus status;
    private String message;
    private AccommodationRequest reportedAccommodation;

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

    public AccommodationRequest getReportedAccommodation() {
        return reportedAccommodation;
    }

    public void setReportedAccommodation(AccommodationRequest reportedAccommodation) {
        this.reportedAccommodation = reportedAccommodation;
    }
}
