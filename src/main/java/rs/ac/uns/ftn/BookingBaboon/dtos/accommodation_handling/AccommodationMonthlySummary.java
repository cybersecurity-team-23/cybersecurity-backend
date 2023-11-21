package rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling;

import lombok.Data;
import java.util.Map;

@Data
public class AccommodationMonthlySummary {
    private String accommodationId;
    private int year;
    private Map<String, Integer> reservationsByMonth;
    private Map<String, Double> profitByMonth;

}
