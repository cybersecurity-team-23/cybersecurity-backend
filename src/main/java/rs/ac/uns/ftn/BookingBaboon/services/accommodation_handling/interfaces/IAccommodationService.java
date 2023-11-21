package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;

import java.util.Collection;

public interface IAccommodationService {
    public Collection<Accommodation> getAll();
    public Accommodation get(Long accommodationId);
    public Accommodation create(Accommodation accommodation);
    public Accommodation update(Accommodation accommodation);
    public void remove(Long accommodationId);
}
