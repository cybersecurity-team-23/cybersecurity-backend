package rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling;

import jakarta.persistence.*;
import lombok.Data;

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

    public void AddAmenity(Amenity amenity){
        amenities.add(amenity);
    }
    public void RemoveAmenity(Amenity amenity){
        amenities.remove(amenity);
    }
}
