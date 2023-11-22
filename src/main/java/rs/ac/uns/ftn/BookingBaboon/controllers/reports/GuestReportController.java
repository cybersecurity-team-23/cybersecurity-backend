package rs.ac.uns.ftn.BookingBaboon.controllers.reports;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.GuestReport;
import rs.ac.uns.ftn.BookingBaboon.dtos.reports.GuestReportRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.reports.GuestReportResponse;
import rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces.IGuestReportService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/guest-reports")
public class GuestReportController {

    private final IGuestReportService guestReportService;
    private final ModelMapper mapper;


    // Get all guest reports
    @GetMapping
    public ResponseEntity<Collection<GuestReport>> getAllGuestReports() {
        Collection<GuestReport> guestReports = guestReportService.getAll();
        return new ResponseEntity<>(guestReports, HttpStatus.OK);
    }

    // Get a guest report by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<GuestReportResponse> get(@PathVariable Long id) {
        GuestReportResponse guestReportResponse = mapper.map(guestReportService.get(id), GuestReportResponse.class);

        if (guestReportResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(guestReportResponse, HttpStatus.OK);
    }

    // Create a new guest report
    @PostMapping(consumes = "application/json")
    public ResponseEntity<GuestReportResponse> create(@RequestBody GuestReportRequest guestReportRequest) {

        GuestReportResponse createdGuestReportResponse = mapper.map(guestReportService.get(guestReportRequest.getId()), GuestReportResponse.class);

        return new ResponseEntity<>(createdGuestReportResponse, HttpStatus.CREATED);
    }

    // Update an existing guest report
    @PutMapping("/{id}")
    public ResponseEntity<GuestReportResponse> update(@PathVariable Long id, @RequestBody GuestReportRequest guestReportRequest) {

        if (guestReportService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        GuestReport updatedGuestReport = guestReportService.update(mapper.map(guestReportRequest, GuestReport.class));
        GuestReportResponse updatedGuestReportResponse = mapper.map(updatedGuestReport, GuestReportResponse.class);

        return new ResponseEntity<>(updatedGuestReportResponse, HttpStatus.OK);
    }

    // Delete a guest report by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {

        if (guestReportService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        guestReportService.remove(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}