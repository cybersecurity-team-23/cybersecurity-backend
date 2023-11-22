package rs.ac.uns.ftn.BookingBaboon.controllers.reservation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.ReservationStatus;
import rs.ac.uns.ftn.BookingBaboon.dtos.reservation.ReservationRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.reservation.ReservationResponse;
import rs.ac.uns.ftn.BookingBaboon.services.reservation.interfaces.IReservationService;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private final IReservationService service;
    private final ModelMapper mapper;

    @GetMapping
    public Collection<ReservationResponse> getAll() {
        Collection<Reservation> reservations = service.getAll();

        return reservations.stream()
                .map(reservation -> mapper.map(reservation, ReservationResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReservationResponse get(@PathVariable Long id) {
        return mapper.map(service.get(id), ReservationResponse.class) ;
    }

    @PostMapping
    public ReservationResponse create(@RequestBody ReservationRequest reservation) {
        return mapper.map(service.get(reservation.getId()), ReservationResponse.class);
    }

    @PutMapping
    public ReservationResponse update(@RequestBody ReservationRequest reservation){
        return mapper.map(service.get(reservation.getId()), ReservationResponse.class);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }

    @PutMapping("/{id}/cancel")
    public ReservationResponse cancel(@PathVariable Long id){
        return mapper.map(service.cancel(id), ReservationResponse.class) ;
    }

    @GetMapping("/filter")
    public Collection<ReservationResponse> search(
            @RequestParam(name = "accommodation-name", required = false) String accommodationName,
            @RequestParam(name = "start-date", required = false) String startDate,
            @RequestParam(name = "end-date", required = false) String endDate,
            @RequestParam(name = "status", required = false) ReservationStatus status) {

        Collection<Reservation> reservations = service.getAll();

        return reservations.stream()
                .map(reservation -> mapper.map(reservation, ReservationResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/cancellation-count/{userId}")
    public int getCancellationCountForUser(@PathVariable Long userId) {
        return service.getCancellationCountForUser(userId);
    }

}
