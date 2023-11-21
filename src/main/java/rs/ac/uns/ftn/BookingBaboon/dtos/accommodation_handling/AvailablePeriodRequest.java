package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling;

import jakarta.persistence.Embedded;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.TimeSlot;

@Data
public class AvailablePeriodRequest {
    private Long id;
    private TimeSlot timeSlot;
    private Float PricePerNight;
}
