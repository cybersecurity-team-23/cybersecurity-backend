package rs.ac.uns.ftn.BookingBaboon.controllers.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.AccommodationRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.AccommodationResponse;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationService;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {

    private final IAccommodationService service;
    private final ModelMapper mapper;

    @GetMapping
    public Collection<AccommodationResponse> getAll() {
        Collection<Accommodation> accommodations = service.getAll();

        return accommodations.stream()
                .map(accommodation -> mapper.map(accommodation, AccommodationResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AccommodationResponse get(@PathVariable Long id) {
        return mapper.map(service.get(id), AccommodationResponse.class) ;
    }

    @PostMapping
    public AccommodationResponse create(@RequestBody AccommodationRequest accommodation) {
        return mapper.map(service.get(accommodation.getId()), AccommodationResponse.class);
    }

    @PutMapping
    public AccommodationResponse update(@RequestBody AccommodationRequest accommodation){
        return mapper.map(service.get(accommodation.getId()), AccommodationResponse.class);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }

    @GetMapping("/filter")
    public Collection<AccommodationResponse> search(
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

        return accommodations.stream()
                .map(accommodation -> mapper.map(accommodation, AccommodationResponse.class))
                .collect(Collectors.toList());
    }

}
