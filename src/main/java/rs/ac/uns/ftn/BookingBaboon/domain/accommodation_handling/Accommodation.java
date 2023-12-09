package rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling;

import jakarta.persistence.*;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.Image;
import rs.ac.uns.ftn.BookingBaboon.domain.users.Host;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "accommodations")
@TableGenerator(name="accommodation_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="accommodation", valueColumnName="value_pk")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "accommodation_id_generator")
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    private Host host;

    @Embedded
    private Location location;

    @ManyToMany
    private List<Amenity> amenities;

    @OneToMany
    private List<AvailablePeriod> availablePeriods;

    private Integer minGuests;
    private Integer maxGuests;
    private Boolean isPricingPerPerson;
    private AccommodationType type;
    private boolean isAutomaticallyAccepted;

    @OneToMany
    private List<Image> images;

    public void AddAmenity(Amenity amenity){
        amenities.add(amenity);
    }
    public void RemoveAmenity(Amenity amenity){
        amenities.remove(amenity);
    }
}
