package rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "accommodation_change_requests")
@TableGenerator(name="accommodation_change_request_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="accommodation_change_request", valueColumnName="value_pk")
public class AccommodationModification {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "accommodation_change_request_id_generator")
    private Long id;

    @ManyToOne
    private Accommodation accommodation;

    private String name;
    private String description;

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

    private Date requestDate;

    @Enumerated
    private ChangeRequestStatus status = ChangeRequestStatus.Pending;

    public void Approve(){
        status = ChangeRequestStatus.Approved;
    }

    public void Deny(){
        status = ChangeRequestStatus.Denied;
    }
}
