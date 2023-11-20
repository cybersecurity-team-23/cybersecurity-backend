package rs.ac.uns.ftn.BookingBaboon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Amenity;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AvailablePeriod;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAmenityService;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAvailablePeriodService;

import java.util.Collection;

@RestController
@RequestMapping("/api/available-period")
public class AvailablePeriodController {
    @Autowired
    IAvailablePeriodService service;

    @GetMapping
    public Collection<AvailablePeriod> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AvailablePeriod get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public AvailablePeriod create(@RequestBody AvailablePeriod availablePeriod) {
        return service.create(availablePeriod);
    }

    @PutMapping
    public AvailablePeriod update(@RequestBody AvailablePeriod availablePeriod){
        return service.update(availablePeriod);
    }

    @DeleteMapping
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }
}
