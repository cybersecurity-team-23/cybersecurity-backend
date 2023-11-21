package rs.ac.uns.ftn.BookingBaboon.dtos.reviews;

import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostRequest;

import java.util.Date;

public class HostReviewRequest {
    private Long id;
    private UserRequest reviewer;
    private Date createdOn;
    private short rating;
    private String comment;
    private HostRequest reviewedHost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRequest getReviewer() {
        return reviewer;
    }

    public void setReviewer(UserRequest reviewer) {
        this.reviewer = reviewer;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public HostRequest getReviewedHost() {
        return reviewedHost;
    }

    public void setReviewedHost(HostRequest reviewedHost) {
        this.reviewedHost = reviewedHost;
    }
}
