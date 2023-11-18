package rs.ac.uns.ftn.BookingBaboon.Domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.Date;

@Embeddable
@Data
public class TimeSlot {
    private Date start;
    private Date end;

    public boolean Overlaps(TimeSlot other) {
        return this.start.before(other.end) && this.end.after(other.start);
    }
}
