package rs.ac.uns.ftn.BookingBaboon.domain.reviews;
import jakarta.persistence.*;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;

@Entity
@Data
@Table(name = "accommodation_reviews")
@TableGenerator(name="accommodation_review_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="accommodation_review", valueColumnName="value_pk")

public class AccommodationReview extends Review {

    @ManyToOne
    private Accommodation reviewedAccommodation;
}
