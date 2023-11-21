package rs.ac.uns.ftn.BookingBaboon.controllers.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.HostReport;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Guest;
import rs.ac.uns.ftn.BookingBaboon.services.reports.HostReportService;
import rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces.IHostReportService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/host-reports")
public class HostReportController {

   private final IHostReportService hostReportService;


    // Get all host reports
    @GetMapping
    public ResponseEntity<Collection<HostReport>> getAllHostReports() {
        Collection<HostReport> hostReports = hostReportService.getAll();
        return new ResponseEntity<>(hostReports, HttpStatus.OK);
    }

    // Get a host report by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<HostReport> getHostReportById(@PathVariable("id") Long id) {
        HostReport hostReport = hostReportService.get(id);

        if (hostReport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hostReport, HttpStatus.OK);
    }

    // Create a new host report
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HostReport> createHostReport(@RequestBody HostReport hostReport) {

        HostReport createdHostReport = hostReportService.create(hostReport);

        return new ResponseEntity<>(createdHostReport, HttpStatus.CREATED);
    }

    // Update an existing host report
    @PutMapping("/{id}")
    public ResponseEntity<HostReport> updateHostReport(@PathVariable Long id, @RequestBody HostReport hostReport) {

        if (hostReportService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        HostReport updatedHostReport = hostReportService.update(hostReport);

        return new ResponseEntity<>(updatedHostReport, HttpStatus.OK);
    }

    // Delete a host report by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeHostReport(@PathVariable Long id) {

        if (hostReportService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        hostReportService.remove(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}