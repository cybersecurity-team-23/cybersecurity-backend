package rs.ac.uns.ftn.BookingBaboon.controllers.users;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.reports.Report;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Admin;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.admins.AdminResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.admins.UserBlockResponse;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IAdminService;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    private final IAdminService service;
    private final ModelMapper mapper;

    @GetMapping
    public Collection<Admin> getAdmins() {
        return this.service.getAll();
    }

    @GetMapping({"/{hostId}"})
    public AdminResponse get(@PathVariable Long hostId) {
        return mapper.map(service.get(hostId),AdminResponse.class);
    }

    @PostMapping({"/"})
    public AdminResponse create(@RequestBody Admin host) {
        return mapper.map(service.create(host),AdminResponse.class);
    }

    @PutMapping({"/"})
    public AdminResponse update(@RequestBody Admin host) {
        return mapper.map(service.update(host),AdminResponse.class);
    }

    @DeleteMapping({"/{hostId}"})
    public AdminResponse remove(@PathVariable Long hostId) {
        return mapper.map(service.remove(hostId),AdminResponse.class);
    }

    //TODO replace with dto
//    GET /reports
    @GetMapping({"/reports"})
    public Collection<Report> getReports(){
        return new ArrayList<Report>();
    }

    //TODO implement missing endpoints
//    GET /approveChanges


//    PUT /accommodations/{accommodationId}?approve={bool}


    @PutMapping({"/block/{userId}"})
    public UserBlockResponse blockUser(@PathVariable Long userId){
        return mapper.map(service.blockUser(userId),UserBlockResponse.class);
    }
}
