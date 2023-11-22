package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation_change_request;

import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.*;

import java.util.Date;
import java.util.Set;

@Data
public class AccommodationChangeRequestResponse {
    private Long id;
    private Accommodation accommodation;
    private String name;
    private String description;
    private Location location;
    private Set<Amenity> amenities;
    private Set<AvailablePeriod> availablePeriods;
    private Integer minGuests;
    private Integer maxGuests;
    private Boolean pricingPerPerson;
    private AccommodationType type;
    private boolean isAutomaticallyAccepted;
    private Date requestDate;
    private ChangeRequestStatus status;
}
