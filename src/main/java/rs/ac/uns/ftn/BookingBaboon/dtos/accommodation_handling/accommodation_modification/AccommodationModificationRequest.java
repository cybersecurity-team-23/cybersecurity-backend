package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation_modification;

import jakarta.validation.constraints.*;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.*;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.Image;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.shared.ImageReference;
import rs.ac.uns.ftn.BookingBaboon.dtos.users.hosts.HostReference;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class AccommodationModificationRequest {
    @Min(0)
    private Long id;

    @NotNull
    private AccommodationReference accommodation;

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
    private Set<Amenity> amenities;

    @NotNull
    private Set<AvailablePeriod> availablePeriods;

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

    @NotNull
    private Set<ImageReference> images;

    @FutureOrPresent
    private Date requestDate;

    @NotNull
    private AccommodationModificationStatus status;

    @NotNull
    private AccommodationModificationType requestType;

    @NotNull
    private Boolean isBeingEdited;

    @Min(1)
    private int cancellationDeadline;
}
