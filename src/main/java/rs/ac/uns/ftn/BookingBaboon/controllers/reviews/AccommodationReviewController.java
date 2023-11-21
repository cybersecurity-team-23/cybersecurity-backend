package rs.ac.uns.ftn.BookingBaboon.controllers.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.reviews.AccommodationReview;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.AccommodationReviewService;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IAccommodationReviewService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accommodation-reviews")
public class AccommodationReviewController {

    private final IAccommodationReviewService accommodationReviewService;


    // Get all accommodation reviews
    @GetMapping
    public ResponseEntity<Collection<AccommodationReview>> getAllAccommodationReviews() {
        Collection<AccommodationReview> accommodationReviews = accommodationReviewService.getAll();
        return new ResponseEntity<>(accommodationReviews, HttpStatus.OK);
    }

    // Get an accommodation review by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<AccommodationReview> getAccommodationReviewById(@PathVariable("id") Long id) {
        AccommodationReview accommodationReview = accommodationReviewService.get(id);

        if (accommodationReview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accommodationReview, HttpStatus.OK);
    }

    // Create a new accommodation review
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccommodationReview> createAccommodationReview(@RequestBody AccommodationReview accommodationReview) {

        AccommodationReview createdAccommodationReview = accommodationReviewService.create(accommodationReview);

        return new ResponseEntity<>(createdAccommodationReview, HttpStatus.CREATED);
    }

    // Update an existing accommodation review
    @PutMapping("/{id}")
    public ResponseEntity<AccommodationReview> updateAccommodationReview(@PathVariable Long id, @RequestBody AccommodationReview accommodationReview) {

        if(accommodationReviewService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        AccommodationReview updatedAccommodationReview = accommodationReviewService.update(accommodationReview);

        return new ResponseEntity<>(updatedAccommodationReview, HttpStatus.OK);
    }

    // Delete an accommodation review by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAccommodationReview(@PathVariable Long id) {

        if (accommodationReviewService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accommodationReviewService.remove(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<Guest> getReviewerById(@PathVariable Long id) {

        if (accommodationReviewService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Guest guest = accommodationReviewService.getReviewer(id);

        return new ResponseEntity<>(guest, HttpStatus.OK);
    }

    @GetMapping("/average-rating/{accommodationId}")
    public ResponseEntity<Float> getAverageRating(@PathVariable Long accommodationId) {

        if (accommodationReviewService.get(accommodationId) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        float averageRating = accommodationReviewService.getAverageRating(accommodationId);

        return new ResponseEntity<>(averageRating, HttpStatus.OK);
    }
}