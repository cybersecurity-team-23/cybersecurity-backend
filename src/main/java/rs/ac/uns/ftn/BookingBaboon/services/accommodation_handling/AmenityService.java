package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling.IAmenityRepository;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAmenityService;

@Service
public class AmenityService implements IAmenityService {
    @Autowired
    private IAmenityRepository amenityRepository;
}
