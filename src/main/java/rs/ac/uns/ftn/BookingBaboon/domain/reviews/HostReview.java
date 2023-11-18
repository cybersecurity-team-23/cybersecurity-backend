package rs.ac.uns.ftn.BookingBaboon.domain.reviews;
import jakarta.persistence.*;
import lombok.Data;
import rs.ac.uns.ftn.BookingBaboon.domain.Users.Host;

@Entity
@Data
@Table(name = "host_reviews")
@TableGenerator(name="host_review_id_generator", table="primary_keys", pkColumnName="key_pk", pkColumnValue="host_review", valueColumnName="value_pk")

public class HostReview extends Review {

    @ManyToOne
    private Host reviewedHost;
}
