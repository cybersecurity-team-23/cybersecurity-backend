package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling;

import jakarta.persistence.*;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationType;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Amenity;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AvailablePeriod;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Location;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostRequest;

import java.util.Set;

@Data
public class AccommodationRequest {
    private Long id;
    private String name;
    private String description;
    private HostRequest host;
    private Location location;
    private Set<AmenityRequest> amenities;
    private Set<AvailablePeriodRequest> availablePeriods;
    private Integer minGuests;
    private Integer maxGuests;
    private Boolean pricingPerPerson;
    private AccommodationType type;
}
