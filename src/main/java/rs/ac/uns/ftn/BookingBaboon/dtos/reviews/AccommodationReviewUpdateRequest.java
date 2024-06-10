package rs.ac.uns.ftn.BookingBaboon.dtos.reviews;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.reviews.ReviewStatus;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserReferenceRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.UserRequest;

import java.util.Date;

@Data
public class AccommodationReviewUpdateRequest {
    @Min(0)
    private Long id;

    @NotNull
    private UserReferenceRequest reviewer;

    @NotNull
    private Date createdOn;

    @Min(0)
    private short rating;

    @Pattern(regexp = "[a-zA-Z0-9 .,]+")
    @Size(min = 1, max = 250)
    private String comment;

    @NotNull
    private AccommodationReference reviewedAccommodation;

    @NotNull
    private ReviewStatus status;
}
