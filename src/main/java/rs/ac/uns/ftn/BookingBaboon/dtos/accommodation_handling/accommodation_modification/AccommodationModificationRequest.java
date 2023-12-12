package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation_modification;

import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.*;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationReference;

import java.util.Date;
import java.util.Set;

@Data
public class AccommodationModificationRequest {
    private Long id;
    private AccommodationReference accommodation;
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
    private AccommodationModificationStatus status;
    private AccommodationModificationType requestType;
}
