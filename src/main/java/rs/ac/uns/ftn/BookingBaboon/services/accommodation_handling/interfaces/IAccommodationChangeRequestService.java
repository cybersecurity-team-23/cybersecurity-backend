package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationChangeRequest;

import java.util.Collection;

public interface IAccommodationChangeRequestService {
    public Collection<AccommodationChangeRequest> getAll();
    public AccommodationChangeRequest get(Long Id);
    public AccommodationChangeRequest create(AccommodationChangeRequest request);
    public AccommodationChangeRequest update(AccommodationChangeRequest request);
    public void remove(Long Id);
}
