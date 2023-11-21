package rs.ac.uns.ftn.BookingBaboon.controllers.users;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation_handling.Reservation;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostNotificationSettings;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostResponse;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostProfile;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IHostService;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/hosts")
public class HostController {
    private final IHostService service;
    private final ModelMapper mapper;

    @GetMapping
    public Collection<Host> getHosts() {
        return this.service.getAll();
    }

    @GetMapping({"/{hostId}"})
    public HostResponse get(@PathVariable Long hostId) {
        return mapper.map(service.get(hostId), HostResponse.class);
    }

    @PostMapping({"/"})
    public HostResponse create(@RequestBody Host host) {
        return mapper.map(service.create(host), HostResponse.class);
    }

    @PutMapping({"/"})
    public HostResponse update(@RequestBody Host host) {
        return mapper.map(service.update(host), HostResponse.class);
    }

    @DeleteMapping({"/{hostId}"})
    public HostResponse remove(@PathVariable Long hostId) {
        return mapper.map(service.remove(hostId), HostResponse.class);
    }

    @GetMapping({"{hostId}/profile"})
    public HostProfile getProfile(@PathVariable Long hostId){
        return mapper.map(service.getProfile(hostId),HostProfile.class);
    }

    @PutMapping({"/{hostId}/toggle-notifications/{notificationType}"})
    public HostNotificationSettings toggleNotifications (@PathVariable Long hostId, @PathVariable NotificationType notificationType){
        return mapper.map(service.toggleNotificaitons(hostId, notificationType),HostNotificationSettings.class);
    }

    @PutMapping({"/reservations/{reservationId}/{isApproved}"})
    public Reservation handleReservation(@PathVariable Long reservationId,@PathVariable boolean isApproved){
        return service.handleReservation(reservationId,isApproved);
    }

}
