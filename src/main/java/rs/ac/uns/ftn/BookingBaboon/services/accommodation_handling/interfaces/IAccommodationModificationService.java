package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces;

import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationModification;

import java.util.HashSet;

public interface IAccommodationModificationService {
    public HashSet<AccommodationModification> getAll();
    public AccommodationModification get(Long Id);
    public AccommodationModification create(AccommodationModification request);
    public AccommodationModification update(AccommodationModification request);
    public AccommodationModification remove(Long Id);
    public void removeAll();

    public AccommodationModification approve(Long id);

    public AccommodationModification deny(Long id);
}
