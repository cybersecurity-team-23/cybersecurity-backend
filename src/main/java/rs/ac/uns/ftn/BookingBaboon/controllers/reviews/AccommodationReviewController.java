package rs.ac.uns.ftn.BookingBaboon.controllers.reviews;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.reviews.AccommodationReview;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.dtos.reviews.AccommodationReviewRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.reviews.AccommodationReviewResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestResponse;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.AccommodationReviewService;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IAccommodationReviewService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accommodation-reviews")
public class AccommodationReviewController {

    private final IAccommodationReviewService service;
    private final ModelMapper mapper;


    // Get all accommodation reviews
    @GetMapping
    public ResponseEntity<Collection<AccommodationReview>> getAllAccommodationReviews() {
        Collection<AccommodationReview> accommodationReviews = service.getAll();
        return new ResponseEntity<>(accommodationReviews, HttpStatus.OK);
    }

    // Get an accommodation review by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<AccommodationReviewResponse> get(@PathVariable Long id) {
        AccommodationReviewResponse accommodationReviewResponse = mapper.map(service.get(id), AccommodationReviewResponse.class);

        if (accommodationReviewResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accommodationReviewResponse, HttpStatus.OK);
    }

    // Create a new accommodation review
    @PostMapping(consumes = "application/json")
    public ResponseEntity<AccommodationReviewResponse> create(@RequestBody AccommodationReviewRequest accommodationReviewRequest) {

        AccommodationReviewResponse createdResponse = mapper.map(service.get(accommodationReviewRequest.getId()), AccommodationReviewResponse.class);

        return new ResponseEntity<>(createdResponse, HttpStatus.CREATED);
    }

    // Update an existing accommodation review
    @PutMapping("/{id}")
    public ResponseEntity<AccommodationReviewResponse> update(@PathVariable Long id, @RequestBody AccommodationReviewRequest accommodationReviewRequest) {

        if (service.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        AccommodationReview updatedAccommodationReview = service.update(mapper.map(accommodationReviewRequest, AccommodationReview.class));
        AccommodationReviewResponse updatedAccommodationReviewResponse = mapper.map(updatedAccommodationReview, AccommodationReviewResponse.class);

        return new ResponseEntity<>(updatedAccommodationReviewResponse, HttpStatus.OK);
    }

    // Delete an accommodation review by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {

        if (service.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.remove(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{accommodationId}/reviewer")
    public ResponseEntity<GuestResponse> getReviewer(@PathVariable Long accommodationId) {

        if (service.get(accommodationId) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        GuestResponse guestResponse = mapper.map(service.getReviewer(accommodationId), GuestResponse.class);

        return new ResponseEntity<>(guestResponse, HttpStatus.OK);
    }

    @GetMapping("/average-rating/{accommodationId}")
    public ResponseEntity<Float> getAverageRating(@PathVariable Long accommodationId) {

        if (service.get(accommodationId) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        float averageRating = service.getAverageRating(accommodationId);

        return new ResponseEntity<>(averageRating, HttpStatus.OK);
    }
}