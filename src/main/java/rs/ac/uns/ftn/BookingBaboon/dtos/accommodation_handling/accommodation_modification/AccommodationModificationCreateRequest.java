package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation_modification;

import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.*;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.amenity.AmenityReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.amenity.AmenityRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.available_period.AvailablePeriodReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.available_period.AvailablePeriodRequest;

import java.util.Date;
import java.util.Set;

@Data
public class AccommodationModificationCreateRequest {
    private AccommodationReference accommodation;
    private String name;
    private String description;
    private Location location;
    private Set<AmenityReference> amenities;
    private Set<AvailablePeriodReference> availablePeriods;
    private Integer minGuests;
    private Integer maxGuests;
    private Boolean pricingPerPerson;
    private AccommodationType type;
    private boolean isAutomaticallyAccepted;
}
