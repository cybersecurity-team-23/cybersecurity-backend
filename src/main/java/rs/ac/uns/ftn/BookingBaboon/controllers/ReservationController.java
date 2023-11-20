package rs.ac.uns.ftn.BookingBaboon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AvailablePeriod;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation_handling.Reservation;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation_handling.ReservationStatus;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAvailablePeriodService;
import rs.ac.uns.ftn.BookingBaboon.services.reservation_handling.interfaces.IReservationService;

import java.util.Collection;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    IReservationService service;

    @GetMapping
    public Collection<Reservation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Reservation get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Reservation create(@RequestBody Reservation reservation) {
        return service.create(reservation);
    }

    @PutMapping
    public Reservation update(@RequestBody Reservation reservation){
        return service.update(reservation);
    }

    @DeleteMapping
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }

    @PutMapping("/{id}/cancel")
    public Reservation cancel(@PathVariable Long id){
        return service.cancel(id);
    }

    @GetMapping("/filter")
    public Collection<Reservation> search(
            @RequestParam(name = "accommodation-name", required = false) String accommodationName,
            @RequestParam(name = "start-date", required = false) String startDate,
            @RequestParam(name = "end-date", required = false) String endDate,
            @RequestParam(name = "status", required = false) ReservationStatus status) {

        return service.getAll();
    }

    @GetMapping("/cancellation-count/{userId}")
    public int getCancellationCountForUser(@PathVariable Long userId) {
        return service.getCancellationCountForUser(userId);
    }

}
