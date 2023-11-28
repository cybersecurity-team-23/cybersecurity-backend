package rs.ac.uns.ftn.BookingBaboon.controllers.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.summary.AccommodationMonthlySummary;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.summary.PeriodSummary;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.ISummaryService;

import java.util.Date;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/summary")
public class SummaryController {

    private final ISummaryService service;

    @GetMapping("/monthly/{accommodationId}")
    public ResponseEntity<AccommodationMonthlySummary> getMonthlySummary(@PathVariable Long accommodationId) {
        AccommodationMonthlySummary monthlySummary = service.getMonthlySummary(accommodationId);
        return new ResponseEntity<>(monthlySummary, HttpStatus.OK);
    }

    @GetMapping("/period")
    public ResponseEntity<PeriodSummary> getPeriodSummary(
            @RequestParam(name = "host-id") String hostId,
            @RequestParam(name = "start-date") Date startDate,
            @RequestParam(name = "end-date") Date endDate) {
        PeriodSummary periodSummary = service.getPeriodSummary(hostId, startDate, endDate);
        return new ResponseEntity<>(periodSummary, HttpStatus.OK);
    }
}
