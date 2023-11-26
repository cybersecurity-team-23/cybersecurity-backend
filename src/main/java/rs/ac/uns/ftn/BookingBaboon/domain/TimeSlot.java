package rs.ac.uns.ftn.BookingBaboon.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.Date;

@Embeddable
@Data
public class TimeSlot {
    private Date startDate;
    private Date endDate;

    public boolean Overlaps(TimeSlot other) {
        return this.startDate.before(other.endDate) && this.endDate.after(other.startDate);
    }
}
