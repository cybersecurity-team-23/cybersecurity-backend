package rs.ac.uns.ftn.BookingBaboon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationMonthlySummary;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.PeriodSummary;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationService;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.ISummaryService;

import java.util.Date;

@RestController
@RequestMapping("/api/summary")
public class SummaryController {
    @Autowired
    ISummaryService service;

    @GetMapping("/monthly/{accommodationId}")
    public AccommodationMonthlySummary getMonthlySummary(@PathVariable Long accommodationId) {
        return service.getMonthlySummary(accommodationId);
    }

    @GetMapping("/period")
    public PeriodSummary getPeriodSummary(
            @RequestParam(name = "host-id") String hostId,
            @RequestParam(name = "start-date") Date startDate,
            @RequestParam(name = "end-date") Date endDate) {
        return service.getPeriodSummary(hostId, startDate, endDate);
    }
}
