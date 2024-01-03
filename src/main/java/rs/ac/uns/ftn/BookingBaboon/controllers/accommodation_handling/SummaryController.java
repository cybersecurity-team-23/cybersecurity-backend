package rs.ac.uns.ftn.BookingBaboon.controllers.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.summary.AccommodationMonthlySummary;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.summary.PeriodSummary;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.ISummaryService;

import java.util.Date;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/summary")
public class SummaryController {

    private final ISummaryService service;

    @PreAuthorize("hasAnyAuthority('HOST')")
    @GetMapping("/monthly/{accommodationId}")
    public ResponseEntity<AccommodationMonthlySummary> getMonthlySummary(@PathVariable Long accommodationId) {
        AccommodationMonthlySummary monthlySummary = service.getMonthlySummary(accommodationId);
        return new ResponseEntity<>(monthlySummary, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('HOST')")
    @GetMapping("/period")
    public ResponseEntity<PeriodSummary> getPeriodSummary(
            @RequestParam(name = "host-id") Long hostId,
            @RequestParam(name = "start-date") String startDate,
            @RequestParam(name = "end-date") String endDate) {
        PeriodSummary periodSummary = service.getPeriodSummary(hostId, startDate, endDate);
        return new ResponseEntity<>(periodSummary, HttpStatus.OK);
    }
}
