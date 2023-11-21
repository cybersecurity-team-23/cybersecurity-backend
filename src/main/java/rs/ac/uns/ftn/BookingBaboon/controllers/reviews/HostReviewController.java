package rs.ac.uns.ftn.BookingBaboon.controllers.reviews;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.reviews.HostReview;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IHostReviewService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/host-reviews")
public class HostReviewController {

    private final IHostReviewService hostReviewService;

    // Get all host reviews
    @GetMapping
    public ResponseEntity<Collection<HostReview>> getAllHostReviews() {
        Collection<HostReview> hostReviews = hostReviewService.getAll();
        return new ResponseEntity<>(hostReviews, HttpStatus.OK);
    }

    // Get a host review by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<HostReview> getHostReviewById(@PathVariable("id") Long id) {
        HostReview hostReview = hostReviewService.get(id);

        if (hostReview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hostReview, HttpStatus.OK);
    }

    // Create a new host review
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HostReview> createHostReview(@RequestBody HostReview hostReview) {

        HostReview createdHostReview = hostReviewService.create(hostReview);

        return new ResponseEntity<>(createdHostReview, HttpStatus.CREATED);
    }

    // Update an existing host review
    @PutMapping("/{id}")
    public ResponseEntity<HostReview> updateHostReview(@PathVariable Long id, @RequestBody HostReview hostReview) {

        if(hostReviewService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        HostReview updatedHostReview = hostReviewService.update(hostReview);

        return new ResponseEntity<>(updatedHostReview, HttpStatus.OK);
    }

    // Delete a host review by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeHostReview(@PathVariable Long id) {

        if (hostReviewService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        hostReviewService.remove(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<Guest> getReviewerById(@PathVariable Long id) {

        if (hostReviewService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Guest guest = hostReviewService.getReviewer(id);

        return new ResponseEntity<>(guest, HttpStatus.OK);
    }
}
