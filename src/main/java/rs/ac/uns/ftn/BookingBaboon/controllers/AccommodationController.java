package rs.ac.uns.ftn.BookingBaboon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationMonthlySummary;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.PeriodSummary;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationService;

import java.util.Collection;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {

    @Autowired
    IAccommodationService service;

    @GetMapping
    public Collection<Accommodation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Accommodation get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Accommodation create(@RequestBody Accommodation accommodation) {
        return service.create(accommodation);
    }

    @PutMapping
    public Accommodation update(@RequestBody Accommodation accommodation){
        return service.update(accommodation);
    }

    @DeleteMapping
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }

    @GetMapping("/filter")
    public Collection<Accommodation> search(
            @RequestParam(name = "destination", required = false) String destination,
            @RequestParam(name = "checkin", required = false) String checkin,
            @RequestParam(name = "checkout", required = false) String checkout,
            @RequestParam(name = "guest-num", required = false) Integer guestNum,
            @RequestParam(name = "min-price", required = false) Double minPrice,
            @RequestParam(name = "max-price", required = false) Double maxPrice,
            @RequestParam(name = "amenity", required = false) String amenity,
            @RequestParam(name = "property-type", required = false) String propertyType,
            @RequestParam(name = "min-rating", required = false) Integer minRating) {
        return service.getAll();
    }

}
