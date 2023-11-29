package rs.ac.uns.ftn.BookingBaboon.controllers.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Amenity;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationCreateRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationResponse;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationService;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accommodations")
public class AccommodationController {

    private final IAccommodationService service;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<Collection<AccommodationResponse>> getAll() {
        Collection<Accommodation> accommodations = service.getAll();

        return new ResponseEntity<>(accommodations.stream()
                .map(accommodation -> mapper.map(accommodation, AccommodationResponse.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccommodationResponse> get(@PathVariable Long id) {
        Accommodation accommodation = service.get(id);

        if (accommodation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(mapper.map(accommodation, AccommodationResponse.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccommodationResponse> create(@RequestBody AccommodationCreateRequest accommodation) {
        Accommodation result = service.create(mapper.map(accommodation, Accommodation.class));
        return new ResponseEntity<>(mapper.map(result, AccommodationResponse.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AccommodationResponse> update(@RequestBody AccommodationRequest accommodation) {
        Accommodation result = service.update(mapper.map(accommodation, Accommodation.class));

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(mapper.map(result, AccommodationResponse.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        Accommodation accommodation = service.get(id);
        if (accommodation != null) {
            service.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<Collection<AccommodationResponse>> search(
            @RequestParam(name = "destination", required = false) String destination,
            @RequestParam(name = "checkin", required = false) String checkin,
            @RequestParam(name = "checkout", required = false) String checkout,
            @RequestParam(name = "guest-num", required = false) Integer guestNum,
            @RequestParam(name = "min-price", required = false) Double minPrice,
            @RequestParam(name = "max-price", required = false) Double maxPrice,
            @RequestParam(name = "amenity", required = false) String amenity,
            @RequestParam(name = "property-type", required = false) String propertyType,
            @RequestParam(name = "min-rating", required = false) Integer minRating) {

        Collection<Accommodation> accommodations = service.getAll();

        return new ResponseEntity<>(accommodations.stream()
                .map(accommodation -> mapper.map(accommodation, AccommodationResponse.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

}
