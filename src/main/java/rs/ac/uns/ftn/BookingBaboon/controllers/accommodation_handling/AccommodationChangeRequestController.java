package rs.ac.uns.ftn.BookingBaboon.controllers.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationChangeRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation_change_request.AccommodationChangeRequestRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation_change_request.AccommodationChangeRequestResponse;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationChangeRequestService;

import javax.net.ssl.SSLEngineResult;
import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accommodation-change-request")
public class AccommodationChangeRequestController {
    private final IAccommodationChangeRequestService service;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<Collection<AccommodationChangeRequestResponse>> getAll() {
        Collection<AccommodationChangeRequestResponse> response = service.getAll().stream()
                .map(request -> mapper.map(request, AccommodationChangeRequestResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccommodationChangeRequestResponse> get(@PathVariable Long id) {
        AccommodationChangeRequestResponse response = mapper.map(service.get(id), AccommodationChangeRequestResponse.class);
        return new ResponseEntity<>(response,  HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<AccommodationChangeRequestResponse> create(@RequestBody AccommodationChangeRequestRequest request) {
        AccommodationChangeRequest result = service.get(request.getId());
        return new ResponseEntity<>(mapper.map(result, AccommodationChangeRequestResponse.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AccommodationChangeRequestResponse> update(@RequestBody AccommodationChangeRequestRequest request) {
        AccommodationChangeRequest result = service.get(request.getId());
        return new ResponseEntity<>(mapper.map(result, AccommodationChangeRequestResponse.class), HttpStatus.OK);
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<AccommodationChangeRequestResponse> approve(@PathVariable Long id) {
        AccommodationChangeRequest request = service.get(id);
        request.Approve();
        return new ResponseEntity<>(mapper.map(request, AccommodationChangeRequestResponse.class), HttpStatus.OK);
    }

    @PutMapping("/deny/{id}")
    public ResponseEntity<AccommodationChangeRequestResponse> deny(@PathVariable Long id) {
        AccommodationChangeRequest request = service.get(id);
        request.Deny();
        return new ResponseEntity<>(mapper.map(request, AccommodationChangeRequestResponse.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
