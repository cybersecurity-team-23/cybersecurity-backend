package rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling;

import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.TimeSlot;
import java.util.Map;

@Data
public class PeriodSummary {
    private TimeSlot period;
    private Map<Long, Integer> reservationsByAccommodation;
    private Map<Long, Double> profitByAccommodation;

}
