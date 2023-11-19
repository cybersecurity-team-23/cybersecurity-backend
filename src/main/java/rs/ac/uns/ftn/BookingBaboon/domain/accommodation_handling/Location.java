package rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.annotation.Annotation;

@Embeddable
@Data
public class Location {
    private String country;
    private String city;
    private String address;
}
