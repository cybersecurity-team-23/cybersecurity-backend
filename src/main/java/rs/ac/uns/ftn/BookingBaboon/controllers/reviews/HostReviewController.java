package rs.ac.uns.ftn.BookingBaboon.controllers.reviews;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.reviews.HostReview;
import rs.ac.uns.ftn.BookingBaboon.dtos.reviews.HostReviewRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.reviews.HostReviewResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.guests.GuestResponse;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IHostReviewService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/host-reviews")
public class HostReviewController {

    private final IHostReviewService service;
    private final ModelMapper mapper;


    // Get all host reviews
    @GetMapping
    public ResponseEntity<Collection<HostReview>> getAllHostReviews() {
        Collection<HostReview> hostReviews = service.getAll();
        return new ResponseEntity<>(hostReviews, HttpStatus.OK);
    }

    // Get a host review by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<HostReviewResponse> get(@PathVariable Long id) {
        HostReviewResponse hostReviewResponse = mapper.map(service.get(id), HostReviewResponse.class);

        if (hostReviewResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hostReviewResponse, HttpStatus.OK);
    }

    // Create a new host review
    @PostMapping(consumes = "application/json")
    public ResponseEntity<HostReviewResponse> create(@RequestBody HostReviewRequest hostReviewRequest) {

        HostReviewResponse createdResponse = mapper.map(service.get(hostReviewRequest.getId()), HostReviewResponse.class);

        return new ResponseEntity<>(createdResponse, HttpStatus.CREATED);
    }

    // Update an existing host review
    @PutMapping("/{id}")
    public ResponseEntity<HostReviewResponse> update(@PathVariable Long id, @RequestBody HostReviewRequest hostReviewRequest) {

        if (service.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        HostReview updatedHostReview = service.update(mapper.map(hostReviewRequest, HostReview.class));
        HostReviewResponse updatedHostReviewResponse = mapper.map(updatedHostReview, HostReviewResponse.class);

        return new ResponseEntity<>(updatedHostReviewResponse, HttpStatus.OK);
    }

    // Delete a host review by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {

        if (service.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.remove(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{hostId}/reviewer")
    public ResponseEntity<GuestResponse> getReviewer(@PathVariable Long hostId) {

        if (service.get(hostId) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        GuestResponse guestResponse = mapper.map(service.getReviewer(hostId), GuestResponse.class);

        return new ResponseEntity<>(guestResponse, HttpStatus.OK);
    }
}
