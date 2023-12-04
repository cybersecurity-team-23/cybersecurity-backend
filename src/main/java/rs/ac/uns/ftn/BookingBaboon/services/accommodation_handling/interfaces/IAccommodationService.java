package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationFilter;

import java.util.Collection;
import java.util.HashSet;

public interface IAccommodationService {
    public HashSet<Accommodation> getAll();
    public Accommodation get(Long accommodationId);
    public Accommodation create(Accommodation accommodation);
    public Accommodation update(Accommodation accommodation);
    public Accommodation remove(Long accommodationId);
    public void removeAll();
    public AccommodationFilter parseFilter(String city, String checkin, String checkout, Integer guestNum, Double minPrice, Double maxPrice, String propertyType, String amenities, Double minRating);
    public Collection<Accommodation> search(AccommodationFilter filter);
}