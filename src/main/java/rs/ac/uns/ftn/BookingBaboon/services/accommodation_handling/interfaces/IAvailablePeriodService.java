package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AvailablePeriod;

import java.util.Collection;

public interface IAvailablePeriodService {
    public Collection<AvailablePeriod> getAll();
    public AvailablePeriod get(Long availablePeriodId);
    public AvailablePeriod create(AvailablePeriod availablePeriod);
    public AvailablePeriod update(AvailablePeriod availablePeriod);
    public AvailablePeriod remove(Long availablePeriodId);
    public void removeAll();
}
