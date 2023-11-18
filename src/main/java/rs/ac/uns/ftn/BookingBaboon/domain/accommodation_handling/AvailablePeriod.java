package rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling;

import jakarta.persistence.*;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.TimeSlot;

@Entity
@Data
@Table(name = "available_period")
@TableGenerator(name="available_period_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="available_period", valueColumnName="value_pk")
public class AvailablePeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "available_period_id_generator")
    private Long id;
    @Embedded
    private TimeSlot timeSlot;
    private Float PricePerNight;
}
