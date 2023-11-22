package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling.IAccommodationRepository;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationService;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AccommodationService implements IAccommodationService {

    @Autowired
    private IAccommodationRepository accommodationRepository;


    @Override
    public Collection<Accommodation> getAll() {
        return new ArrayList<Accommodation>();
    }

    @Override
    public Accommodation get(Long accommodationId) {
        return new Accommodation();
    }

    @Override
    public Accommodation create(Accommodation accommodation) {
        return new Accommodation();
    }

    @Override
    public Accommodation update(Accommodation accommodation) {
        return new Accommodation();
    }

    @Override
    public void remove(Long accommodationId) {

    }

}
