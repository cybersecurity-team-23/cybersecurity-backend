package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationType;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Location;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.amenity.AmenityReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.amenity.AmenityRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.available_period.AvailablePeriodRequest;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostRequest;

import java.util.Set;

@Data
public class AccommodationCreateRequest {
    @Size(min = 1, max = 50)
    @Pattern(regexp = "[a-zA-Z0-9 ]+")
    private String name;

    @Pattern(regexp = "[a-zA-Z0-9 .,]+")
    @Size(min = 1, max = 250)
    private String description;

    @NotNull
    private HostReference host;

    @NotNull
    private Location location;

    @NotNull
    private Set<AmenityReference> amenities;

    @NotNull
    private Set<AccommodationReference> availablePeriods;

    @Min(1)
    private Integer minGuests;

    @Min(1)
    private Integer maxGuests;

    @NotNull
    private Boolean isPricingPerPerson;

    @NotNull
    private AccommodationType type;

    @NotNull
    private boolean isAutomaticallyAccepted;

    @Min(1)
    private int cancellationDeadline;
}
