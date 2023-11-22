package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationChangeRequest;
import rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling.IAccommodationChangeRequestRepository;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationChangeRequestService;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AccommodationChangeRequestService implements IAccommodationChangeRequestService {

    @Autowired
    private IAccommodationChangeRequestRepository requestRepository;

    @Override
    public Collection<AccommodationChangeRequest> getAll() {
        return new ArrayList<AccommodationChangeRequest>();
    }

    @Override
    public AccommodationChangeRequest get(Long accommodationId) {
        return new AccommodationChangeRequest();
    }

    @Override
    public AccommodationChangeRequest create(AccommodationChangeRequest accommodation) {
        return new AccommodationChangeRequest();
    }

    @Override
    public AccommodationChangeRequest update(AccommodationChangeRequest accommodation) {
        return new AccommodationChangeRequest();
    }

    @Override
    public void remove(Long accommodationId) {

    }


}
