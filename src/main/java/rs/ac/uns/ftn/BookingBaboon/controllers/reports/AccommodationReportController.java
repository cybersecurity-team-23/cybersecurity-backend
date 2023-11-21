package rs.ac.uns.ftn.BookingBaboon.controllers.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.AccommodationReport;
import rs.ac.uns.ftn.BookingBaboon.services.reports.AccommodationReportService;
import rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces.IAccommodationReportService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accommodation-reports")
public class AccommodationReportController {

    private final IAccommodationReportService accommodationReportService;


    // Get all accommodation reports
    @GetMapping
    public ResponseEntity<Collection<AccommodationReport>> getAllAccommodationReports() {
        Collection<AccommodationReport> accommodationReports = accommodationReportService.getAll();
        return new ResponseEntity<>(accommodationReports, HttpStatus.OK);
    }

    // Get a accommodation report by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<AccommodationReport> getAccommodationReportById(@PathVariable("id") Long id) {
        AccommodationReport accommodationReport = accommodationReportService.get(id);

        if (accommodationReport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accommodationReport, HttpStatus.OK);
    }

    // Create a new accommodation report
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccommodationReport> createAccommodationReport(@RequestBody AccommodationReport accommodationReport) {

        AccommodationReport createdAccommodationReport = accommodationReportService.create(accommodationReport);

        return new ResponseEntity<>(createdAccommodationReport, HttpStatus.CREATED);
    }

    // Update an existing accommodation report
    @PutMapping("/{id}")
    public ResponseEntity<AccommodationReport> updateAccommodationReport(@PathVariable Long id, @RequestBody AccommodationReport accommodationReport) {

        if (accommodationReportService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        AccommodationReport updatedAccommodationReport = accommodationReportService.update(accommodationReport);

        return new ResponseEntity<>(updatedAccommodationReport, HttpStatus.OK);
    }

    // Delete a accommodation report by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAccommodationReport(@PathVariable Long id) {

        if (accommodationReportService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accommodationReportService.remove(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}