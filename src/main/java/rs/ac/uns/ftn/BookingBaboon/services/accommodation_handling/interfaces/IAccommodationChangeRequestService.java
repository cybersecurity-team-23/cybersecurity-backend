package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationChangeRequest;

import java.util.Collection;
import java.util.HashSet;

public interface IAccommodationChangeRequestService {
    public HashSet<AccommodationChangeRequest> getAll();
    public AccommodationChangeRequest get(Long Id);
    public AccommodationChangeRequest create(AccommodationChangeRequest request);
    public AccommodationChangeRequest update(AccommodationChangeRequest request);
    public AccommodationChangeRequest remove(Long Id);
    public void removeAll();
}
