package rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling;

import jakarta.persistence.*;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.Image;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "accommodation_modifications")
@TableGenerator(name="accommodation_modification_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="accommodation_modification", initialValue = 5, valueColumnName="value_pk")
public class AccommodationModification {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "accommodation_modification_id_generator")
    private Long id;

    @ManyToOne
    private Accommodation accommodation;

    private String name;
    private String description;
    @ManyToOne
    private Host host;
    @Embedded
    private Location location;

    @ManyToMany
    private Set<Amenity> amenities;

    @OneToMany
    private Set<AvailablePeriod> availablePeriods;

    private Integer minGuests;
    private Integer maxGuests;
    private Boolean pricingPerPerson;
    private AccommodationType type;
    private boolean isAutomaticallyAccepted;

    @OneToMany
    private List<Image> images;

    private Date requestDate;

    @Enumerated
    private AccommodationModificationStatus status = AccommodationModificationStatus.Pending;
    @Enumerated
    private AccommodationModificationType requestType;

    public void Approve(){
        status = AccommodationModificationStatus.Approved;
    }

    public void Deny(){
        status = AccommodationModificationStatus.Denied;
    }
}
