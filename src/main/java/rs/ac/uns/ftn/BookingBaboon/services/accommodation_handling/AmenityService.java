package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Amenity;
import rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling.IAmenityRepository;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAmenityService;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AmenityService implements IAmenityService {
    @Autowired
    private IAmenityRepository amenityRepository;

    @Override
    public Collection<Amenity> getAll() {
        return new ArrayList<Amenity>();
    }

    @Override
    public Amenity get(Long amenityId) {
        return new Amenity();
    }

    @Override
    public Amenity create(Amenity amenity) {
        return new Amenity();
    }

    @Override
    public Amenity update(Amenity amenity) {
        return new Amenity();
    }

    @Override
    public void remove(Long amenityId) {

    }
}
