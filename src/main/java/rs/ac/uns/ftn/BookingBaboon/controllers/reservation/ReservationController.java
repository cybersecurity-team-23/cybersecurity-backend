package rs.ac.uns.ftn.BookingBaboon.controllers.reservation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.ReservationStatus;
import rs.ac.uns.ftn.BookingBaboon.dtos.reservation.ReservationCreateRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.reservation.ReservationRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.reservation.ReservationResponse;
import rs.ac.uns.ftn.BookingBaboon.services.reservation.interfaces.IReservationService;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    private final IReservationService service;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<Collection<ReservationResponse>> getAll() {
        Collection<Reservation> reservations = service.getAll();
        return new ResponseEntity<>(reservations.stream()
                .map(reservation -> mapper.map(reservation, ReservationResponse.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponse> get(@PathVariable Long id) {
        Reservation reservation = service.get(id);
        return new ResponseEntity<>(mapper.map(reservation, ReservationResponse.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> create(@RequestBody ReservationCreateRequest reservation) {
        Reservation result = service.create(mapper.map(reservation, Reservation.class));
        return new ResponseEntity<>(mapper.map(result, ReservationResponse.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ReservationResponse> update(@RequestBody ReservationRequest reservation) {
        Reservation result = service.update(mapper.map(reservation, Reservation.class));
        return new ResponseEntity<>(mapper.map(result, ReservationResponse.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<ReservationResponse> cancel(@PathVariable Long id) {
        Reservation result = service.cancel(id);
        return new ResponseEntity<>(mapper.map(result, ReservationResponse.class), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<Collection<ReservationResponse>> search(
            @RequestParam(name = "accommodation-name", required = false) String accommodationName,
            @RequestParam(name = "start-date", required = false) String startDate,
            @RequestParam(name = "end-date", required = false) String endDate,
            @RequestParam(name = "status", required = false) ReservationStatus status) {

        Collection<Reservation> reservations = service.getAll();
        return new ResponseEntity<>(reservations.stream()
                .map(reservation -> mapper.map(reservation, ReservationResponse.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/cancellation-count/{userId}")
    public ResponseEntity<Integer> getCancellationCountForUser(@PathVariable Long userId) {
        int cancellationCount = service.getCancellationCountForUser(userId);
        return new ResponseEntity<>(cancellationCount, HttpStatus.OK);
    }

}
