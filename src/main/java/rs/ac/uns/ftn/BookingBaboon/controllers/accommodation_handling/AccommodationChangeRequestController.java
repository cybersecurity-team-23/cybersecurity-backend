package rs.ac.uns.ftn.BookingBaboon.controllers.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationChangeRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation_change_request.AccommodationChangeRequestRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation_change_request.AccommodationChangeRequestResponse;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationChangeRequestService;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accommodation-change-request")
public class AccommodationChangeRequestController {
    private final IAccommodationChangeRequestService service;
    private final ModelMapper mapper;

    @GetMapping
    public Collection<AccommodationChangeRequestResponse> getAll() {
        Collection<AccommodationChangeRequest> accommodations = service.getAll();

        return accommodations.stream()
                .map(request -> mapper.map(request, AccommodationChangeRequestResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AccommodationChangeRequestResponse get(@PathVariable Long id) {
        return mapper.map(service.get(id), AccommodationChangeRequestResponse.class) ;
    }

    @PostMapping
    public AccommodationChangeRequestResponse create(@RequestBody AccommodationChangeRequestRequest request) {
        return mapper.map(service.get(request.getId()), AccommodationChangeRequestResponse.class);
    }

    @PutMapping
    public AccommodationChangeRequestResponse update(@RequestBody AccommodationChangeRequestRequest request){
        return mapper.map(service.get(request.getId()), AccommodationChangeRequestResponse.class);
    }

    @PutMapping("/approve/{id}")
    public AccommodationChangeRequestResponse approve(@PathVariable Long id){
        service.get(id).Approve();
        return mapper.map(service.get(id), AccommodationChangeRequestResponse.class);
    }

    @PutMapping("/deny/{id}")
    public AccommodationChangeRequestResponse deny(@PathVariable Long id){
        service.get(id).Deny();
        return mapper.map(service.get(id), AccommodationChangeRequestResponse.class);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }
}
