package rs.ac.uns.ftn.BookingBaboon.controllers.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    public Collection<AvailablePeriodResponse> getAll() {
        Collection<AvailablePeriod> availablePeriods = service.getAll();

        return availablePeriods.stream()
                .map(availablePeriod -> mapper.map(availablePeriod, AvailablePeriodResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AvailablePeriodResponse get(@PathVariable Long id) {
        return mapper.map(service.get(id), AvailablePeriodResponse.class);
    }

    @PostMapping
    public AvailablePeriodResponse create(@RequestBody AvailablePeriodRequest availablePeriod) {
        return mapper.map(service.get(availablePeriod.getId()), AvailablePeriodResponse.class);
    }

    @PutMapping
    public AvailablePeriodResponse update(@RequestBody AvailablePeriodRequest availablePeriod){
        return mapper.map(service.get(availablePeriod.getId()), AvailablePeriodResponse.class);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }
}
