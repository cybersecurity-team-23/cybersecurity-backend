package rs.ac.uns.ftn.BookingBaboon.dtos.users.guests;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class GuestReference {
    @Min(0)
    private Long id;

    public GuestReference(){

    }
    public GuestReference(long id) {
        this.id = id;
    }
}
