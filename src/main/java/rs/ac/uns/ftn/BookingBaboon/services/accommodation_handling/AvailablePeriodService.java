package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AvailablePeriod;
import rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling.IAvailablePeriodRepository;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAvailablePeriodService;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AvailablePeriodService implements IAvailablePeriodService {

    @Autowired
    private IAvailablePeriodRepository availablePeriodRepository;

    @Override
    public Collection<AvailablePeriod> getAll() {
        return new ArrayList<AvailablePeriod>();
    }

    @Override
    public AvailablePeriod get(Long availablePeriodId) {
        return new AvailablePeriod();
    }

    @Override
    public AvailablePeriod create(AvailablePeriod availablePeriod) {
        return new AvailablePeriod();
    }

    @Override
    public AvailablePeriod update(AvailablePeriod availablePeriod) {
        return new AvailablePeriod();
    }

    @Override
    public void remove(Long availablePeriodId) {

    }
}
