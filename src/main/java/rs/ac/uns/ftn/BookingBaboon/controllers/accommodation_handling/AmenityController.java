package rs.ac.uns.ftn.BookingBaboon.controllers.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Amenity;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.amenity.AmenityRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.amenity.AmenityResponse;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAmenityService;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/amenity")
public class AmenityController {

    private final IAmenityService service;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<Collection<AmenityResponse>> getAll() {
        Collection<Amenity> amenities = service.getAll();

        return new ResponseEntity<>(amenities.stream()
                .map(amenity -> mapper.map(amenity, AmenityResponse.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmenityResponse> get(@PathVariable Long id) {
        Amenity amenity = service.get(id);
        return new ResponseEntity<>(mapper.map(amenity, AmenityResponse.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AmenityResponse> create(@RequestBody AmenityRequest amenity) {
        Amenity result = service.get(amenity.getId());
        return new ResponseEntity<>(mapper.map(result, AmenityResponse.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AmenityResponse> update(@RequestBody AmenityRequest amenity) {
        Amenity result = service.get(amenity.getId());
        return new ResponseEntity<>(mapper.map(result, AmenityResponse.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
