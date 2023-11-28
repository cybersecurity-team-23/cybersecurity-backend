package rs.ac.uns.ftn.BookingBaboon.controllers.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationModification;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation_modification.AccommodationModificationCreateRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation_modification.AccommodationModificationRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation_modification.AccommodationModificationResponse;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationModificationService;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accommodation-change-requests")
public class AccommodationModificationController {
    private final IAccommodationModificationService service;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<Collection<AccommodationModificationResponse>> getAll() {
        Collection<AccommodationModificationResponse> response = service.getAll().stream()
                .map(request -> mapper.map(request, AccommodationModificationResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccommodationModificationResponse> get(@PathVariable Long id) {
        AccommodationModificationResponse response = mapper.map(service.get(id), AccommodationModificationResponse.class);
        return new ResponseEntity<>(response,  HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<AccommodationModificationResponse> create(@RequestBody AccommodationModificationCreateRequest request) {
        AccommodationModification result = service.create(mapper.map(request, AccommodationModification.class));
        return new ResponseEntity<>(mapper.map(result, AccommodationModificationResponse.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AccommodationModificationResponse> update(@RequestBody AccommodationModificationRequest request) {
        AccommodationModification result = service.update(mapper.map(request, AccommodationModification.class));
        return new ResponseEntity<>(mapper.map(result, AccommodationModificationResponse.class), HttpStatus.OK);
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<AccommodationModificationResponse> approve(@PathVariable Long id) {
        AccommodationModification request = service.get(id);
        request.Approve();
        return new ResponseEntity<>(mapper.map(request, AccommodationModificationResponse.class), HttpStatus.OK);
    }

    @PutMapping("/deny/{id}")
    public ResponseEntity<AccommodationModificationResponse> deny(@PathVariable Long id) {
        AccommodationModification request = service.get(id);
        request.Deny();
        return new ResponseEntity<>(mapper.map(request, AccommodationModificationResponse.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
