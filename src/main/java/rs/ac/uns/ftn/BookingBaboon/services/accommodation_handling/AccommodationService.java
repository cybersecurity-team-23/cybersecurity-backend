package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationFilter;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationType;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Amenity;
import rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling.IAccommodationRepository;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationService;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAmenityService;
import rs.ac.uns.ftn.BookingBaboon.services.reviews.interfaces.IAccommodationReviewService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RequiredArgsConstructor
@Service
public class AccommodationService implements IAccommodationService {
    private final IAccommodationRepository repository;
    private final IAmenityService amenityService;
    ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", LocaleContextHolder.getLocale());

    @Override
    public HashSet<Accommodation> getAll() {
        return new HashSet<Accommodation>(repository.findAll());
    }

    @Override
    public Accommodation get(Long accommodationId) {
        Optional<Accommodation> found = repository.findById(accommodationId);
        if (found.isEmpty()) {
            String value = bundle.getString("accommodation.notFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, value);
        }
        return found.get();
    }

    @Override
    public Accommodation create(Accommodation accommodation) {
        try {
            repository.save(accommodation);
            repository.flush();
            return accommodation;
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> errors = ex.getConstraintViolations();
            StringBuilder sb = new StringBuilder(1000);
            for (ConstraintViolation<?> error : errors) {
                sb.append(error.getMessage()).append("\n");
            }
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, sb.toString());
        }
    }

    @Override
    public Accommodation update(Accommodation accommodation) {
        try {
            get(accommodation.getId()); // this will throw AccommodationNotFoundException if accommodation is not found
            repository.save(accommodation);
            repository.flush();
            return accommodation;
        } catch (RuntimeException ex) {
            Throwable e = ex;
            Throwable c = null;
            while ((e != null) && !((c = e.getCause()) instanceof ConstraintViolationException) ) {
                e = (RuntimeException) c;
            }
            if ((c != null) && (c instanceof ConstraintViolationException)) {
                ConstraintViolationException c2 = (ConstraintViolationException) c;
                Set<ConstraintViolation<?>> errors = c2.getConstraintViolations();
                StringBuilder sb = new StringBuilder(1000);
                for (ConstraintViolation<?> error : errors) {
                    sb.append(error.getMessage() + "\n");
                }
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, sb.toString());
            }
            throw ex;
        }
    }

    @Override
    public Accommodation remove(Long accommodationId) {
        Accommodation found = get(accommodationId);
        repository.delete(found);
        repository.flush();
        return found;
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
        repository.flush();
    }

    public AccommodationFilter parseFilter(String city, String checkin, String checkout, Integer guestNum, Double minPrice, Double maxPrice, String propertyType, String amenities, Double minRating){
        AccommodationFilter filter = new AccommodationFilter();
        filter.setCity(city);
        filter.setCheckin(parseDate(checkin));
        filter.setCheckout(parseDate(checkout));
        filter.setGuestNum(guestNum);
        filter.setMinPrice(minPrice);
        filter.setMaxPrice(maxPrice);
        filter.setAmenities(parseAmenities(amenities));
        filter.setType(parseAccommodationType(propertyType));
        filter.setMinRating(minRating);

        return filter;
    }

    private Date parseDate(String date){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (date != null) {
                return dateFormat.parse(date);
            }
        } catch (ParseException e) {
            // Handle the exception or log it
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        return null;
    }

    //Amenity form => /filter?amenity=Wi-Fi,Swimming%20Pool,Parking
    private Set<Amenity> parseAmenities(String amenityString) {
        if (amenityString == null || amenityString.isEmpty()) {
            return null;
        }

        String decodedAmenities = URLDecoder.decode(amenityString, StandardCharsets.UTF_8);

        String[] amenityNames = decodedAmenities.split(",");

        Set<Amenity> amenities = new HashSet<>();
        for (String amenityName : amenityNames) {
            Amenity existingAmenity = amenityService.findByName(amenityName);
            if (existingAmenity != null) {
                amenities.add(existingAmenity);
            }
        }

        return amenities;
    }

    // Helper method to parse AccommodationType from a string
    private AccommodationType parseAccommodationType(String typeString) {
        if (typeString == null || typeString.isEmpty()) {
            return null;
        }
        return AccommodationType.valueOf(typeString); // Assuming the enum has the same name as the strings
    }

    @Override
    public Collection<Accommodation> search(AccommodationFilter filter){
        return repository.findAccommodationsByFilter(
                filter
//                filter.getCity(),
//                filter.getCheckin(),
//                filter.getCheckout(),
//                filter.getGuestNum(),
//                filter.getMinPrice(),
//                filter.getMaxPrice(),
//                filter.getType(),
//                filter.getAmenities(),
//                filter.getMinRating()
        );
    }

}