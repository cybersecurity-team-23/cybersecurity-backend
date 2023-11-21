package rs.ac.uns.ftn.BookingBaboon.controllers.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Amenity;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.AccommodationResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.AmenityRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.AmenityResponse;
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
    public Collection<AmenityResponse> getAll() {
        Collection<Amenity> amenities = service.getAll();

        return amenities.stream()
                .map(amenity -> mapper.map(amenity, AmenityResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AmenityResponse get(@PathVariable Long id) {
        return mapper.map(service.get(id), AmenityResponse.class);
    }

    @PostMapping
    public AmenityResponse create(@RequestBody AmenityRequest amenity) {
        return mapper.map(service.get(amenity.getId()), AmenityResponse.class);
    }

    @PutMapping
    public AmenityResponse update(@RequestBody AmenityRequest amenity){
        return mapper.map(service.get(amenity.getId()), AmenityResponse.class);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }
}
