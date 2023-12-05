package rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Entity
@Data
@Table(name = "amenities")
@TableGenerator(name="amenity_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="amenity", valueColumnName="value_pk")
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "amenity_id_generator")
    private Long id;
    private String name;
}
