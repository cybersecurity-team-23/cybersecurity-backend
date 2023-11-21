package rs.ac.uns.ftn.BookingBaboon.dtos.reviews;

import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostResponse;

import java.util.Date;

public class HostReviewResponse {
    private Long id;
    private HostResponse reviewer;
    private Date createdOn;
    private short rating;
    private String comment;
    private HostResponse reviewedHost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HostResponse getReviewer() {
        return reviewer;
    }

    public void setReviewer(HostResponse reviewer) {
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

    public HostResponse getReviewedHost() {
        return reviewedHost;
    }

    public void setReviewedHost(HostResponse reviewedHost) {
        this.reviewedHost = reviewedHost;
    }
}
