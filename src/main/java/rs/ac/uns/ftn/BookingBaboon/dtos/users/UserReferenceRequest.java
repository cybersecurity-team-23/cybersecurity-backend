package rs.ac.uns.ftn.BookingBaboon.dtos.users;

import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.annotations.EmbeddableInstantiator;

@Data
public class UserReferenceRequest {
    @Min(0)
    public Long id;
}
