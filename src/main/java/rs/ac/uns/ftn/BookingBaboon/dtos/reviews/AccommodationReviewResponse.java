package rs.ac.uns.ftn.BookingBaboon.dtos.reviews;

import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.AccommodationResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserResponse;

import java.util.Date;

public class AccommodationReviewResponse {
    private Long id;
    private UserResponse reviewer;
    private Date createdOn;
    private short rating;
    private String comment;
    private AccommodationResponse reviewedAccommodation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserResponse getReviewer() {
        return reviewer;
    }

    public void setReviewer(UserResponse reviewer) {
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

    public AccommodationResponse getReviewedAccommodation() {
        return reviewedAccommodation;
    }

    public void setReviewedAccommodation(AccommodationResponse reviewedAccommodation) {
        this.reviewedAccommodation = reviewedAccommodation;
    }
}
