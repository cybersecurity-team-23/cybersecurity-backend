package rs.ac.uns.ftn.BookingBaboon.controllers.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.summary.AccommodationMonthlySummary;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.summary.PeriodSummary;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.ISummaryService;

import java.util.Date;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/summary")
public class SummaryController {

    private final ISummaryService service;
    private final ModelMapper mapper;

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
