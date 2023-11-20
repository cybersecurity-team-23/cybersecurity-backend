package rs.ac.uns.ftn.BookingBaboon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Amenity;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAmenityService;

import java.util.Collection;

@RestController
@RequestMapping("/api/amenity")
public class AmenityController {
    @Autowired
    IAmenityService service;

    @GetMapping
    public Collection<Amenity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Amenity get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Amenity create(@RequestBody Amenity amenity) {
        return service.create(amenity);
    }

    @PutMapping
    public Amenity update(@RequestBody Amenity amenity){
        return service.update(amenity);
    }

    @DeleteMapping
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }
}
