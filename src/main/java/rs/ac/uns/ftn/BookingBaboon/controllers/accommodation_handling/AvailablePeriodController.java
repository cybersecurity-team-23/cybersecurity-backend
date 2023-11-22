package rs.ac.uns.ftn.BookingBaboon.controllers.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AvailablePeriod;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.available_period.AvailablePeriodRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.available_period.AvailablePeriodResponse;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAvailablePeriodService;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/available-period")
public class AvailablePeriodController {

    private final IAvailablePeriodService service;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<Collection<AvailablePeriodResponse>> getAll() {
        Collection<AvailablePeriod> availablePeriods = service.getAll();

        return new ResponseEntity<>(availablePeriods.stream()
                .map(availablePeriod -> mapper.map(availablePeriod, AvailablePeriodResponse.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvailablePeriodResponse> get(@PathVariable Long id) {
        AvailablePeriod availablePeriod = service.get(id);
        return new ResponseEntity<>(mapper.map(availablePeriod, AvailablePeriodResponse.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AvailablePeriodResponse> create(@RequestBody AvailablePeriodRequest availablePeriod) {
        AvailablePeriod result = service.get(availablePeriod.getId());
        return new ResponseEntity<>(mapper.map(result, AvailablePeriodResponse.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AvailablePeriodResponse> update(@RequestBody AvailablePeriodRequest availablePeriod) {
        AvailablePeriod result = service.get(availablePeriod.getId());
        return new ResponseEntity<>(mapper.map(result, AvailablePeriodResponse.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
