package rs.ac.uns.ftn.BookingBaboon.dtos.reports;

import rs.ac.uns.ftn.BookingBaboon.domain.reports.ReportStatus;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.AccommodationResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserResponse;

import java.util.Date;

public class AccommodationReportResponse {
    private Long id;
    private UserResponse reportee;
    private Date createdOn;
    private ReportStatus status;
    private String message;
    private AccommodationResponse reportedAccommodation;

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

    public AccommodationResponse getReportedAccommodation() {
        return reportedAccommodation;
    }

    public void setReportedAccommodation(AccommodationResponse reportedAccommodation) {
        this.reportedAccommodation = reportedAccommodation;
    }
}
