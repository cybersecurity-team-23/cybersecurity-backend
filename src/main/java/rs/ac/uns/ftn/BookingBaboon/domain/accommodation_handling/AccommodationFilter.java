package rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class AccommodationFilter {
    String city;
    LocalDate checkin;
    LocalDate checkout;
    Integer guestNum;
    Double minPrice;
    Double maxPrice;
    List<String> amenities;
    List<AccommodationType> types;
    Double minRating;
}