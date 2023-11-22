package rs.ac.uns.ftn.BookingBaboon.controllers.reports;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.HostReport;
import rs.ac.uns.ftn.BookingBaboon.dtos.reports.HostReportRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.reports.HostReportResponse;
import rs.ac.uns.ftn.BookingBaboon.services.reports.interfaces.IHostReportService;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/host-reports")
public class HostReportController {

    private final IHostReportService hostReportService;
    private final ModelMapper mapper;


    // Get all host reports
    @GetMapping
    public ResponseEntity<Collection<HostReport>> getAllHostReports() {
        Collection<HostReport> hostReports = hostReportService.getAll();
        return new ResponseEntity<>(hostReports, HttpStatus.OK);
    }

    // Get a host report by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<HostReportResponse> get(@PathVariable Long id) {
        HostReportResponse hostReportResponse = mapper.map(hostReportService.get(id), HostReportResponse.class);

        if (hostReportResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hostReportResponse, HttpStatus.OK);
    }

    // Create a new host report
    @PostMapping(consumes = "application/json")
    public ResponseEntity<HostReportResponse> create(@RequestBody HostReportRequest hostReportRequest) {

        HostReportResponse createdHostReportResponse = mapper.map(hostReportService.get(hostReportRequest.getId()), HostReportResponse.class);

        return new ResponseEntity<>(createdHostReportResponse, HttpStatus.CREATED);
    }

    // Update an existing host report
    @PutMapping("/{id}")
    public ResponseEntity<HostReportResponse> update(@PathVariable Long id, @RequestBody HostReportRequest hostReportRequest) {

        if (hostReportService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        HostReport updatedHostReport = hostReportService.update(mapper.map(hostReportRequest, HostReport.class));
        HostReportResponse updatedHostReportResponse = mapper.map(updatedHostReport, HostReportResponse.class);

        return new ResponseEntity<>(updatedHostReportResponse, HttpStatus.OK);
    }

    // Delete a host report by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {

        if (hostReportService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        hostReportService.remove(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}