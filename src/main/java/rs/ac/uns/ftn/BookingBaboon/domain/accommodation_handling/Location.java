package rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Embeddable
@Data
@Table(name = "locations")
@TableGenerator(name="location_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="location", valueColumnName="value_pk")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "location_id_generator")
    private Long id;
    private String country;
    private String city;
    private String address;
}
