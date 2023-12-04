package rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationFilter;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationType;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Amenity;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Repository
public interface IAccommodationRepository extends JpaRepository<Accommodation, Long> {


    @Query("SELECT DISTINCT a FROM Accommodation a " +
            "WHERE (:#{#filter.city} IS NULL OR a.location.city = :#{#filter.city})")
    Set<Accommodation> findAccommodationsByFilter(
            @Param("filter") AccommodationFilter filter
//            @Param("city") String city,
//            @Param("checkin") Date checkin,
//            @Param("checkout") Date checkout,
//            @Param("guestNum") Integer guestNum,
//            @Param("minPrice") Double minPrice,
//            @Param("maxPrice") Double maxPrice,
//            @Param("type") AccommodationType type,
//            @Param("amenities") Set<Amenity> amenities,
//            @Param("minRating") Double minRating
    );





//    @Query("SELECT DISTINCT a FROM Accommodation a " +
//            "LEFT JOIN AccommodationReview r ON a.id = r.reviewedAccommodation.id " +
//            "WHERE " +
//            "(:city is null or a.location.city = :city) and " +
//            "((:checkin is null or :checkout is null) or " +
//            "NOT EXISTS (" +
//            "SELECT ap FROM AvailablePeriod ap WHERE " +
//            "ap member of a.availablePeriods and " +
//            "ap.timeSlot.startDate >= :checkin and " +
//            "ap.timeSlot.endDate <= :checkout)) and " +
//            "(:guestNum is null or a.maxGuests >= :guestNum) and " +
//            "(:type is null or a.type = :type) and " +
//            "(:amenities is null or :amenities.isEmpty() or " +
//            "SIZE(:amenities) = (" +
//            "SELECT COUNT(DISTINCT amenity) FROM Accommodation a " +
//            "JOIN a.amenities amenity " +
//            "WHERE amenity IN :amenities)) and " +
//            "(:minRating is null or " +
//            "COALESCE((SELECT AVG(r.rating) FROM AccommodationReview r WHERE r.reviewedAccommodation.id = a.id), 0) >= :minRating) and " +
//            "(:minPrice is null or a.price >= :minPrice) and " +
//            "(:maxPrice is null or a.price <= :maxPrice)")
//    HashSet<Accommodation> findAccommodationsByFilter(
//            @Param("city") String city,
//            @Param("checkin") Date checkin,
//            @Param("checkout") Date checkout,
//            @Param("guestNum") Integer guestNum,
//            @Param("type") AccommodationType type,
//            @Param("amenities") Set<Amenity> amenities,
//            @Param("minRating") Double minRating,
//            @Param("minPrice") Double minPrice,
//            @Param("maxPrice") Double maxPrice);



//    @Query("SELECT DISTINCT a FROM Accommodation a " +
//            "LEFT JOIN AccommodationReview r ON a.id = r.reviewedAccommodation.id " +
//            "WHERE " +
//            "(:#{#filter.city} is null or a.location.city = :#{#filter.city}) and " +
//            "((:#{#filter.checkin} is null or :#{#filter.checkout} is null) or " +
//            "NOT EXISTS (" +
//            "SELECT ap FROM AvailablePeriod ap WHERE " +
//            "ap member of a.availablePeriods and " +
//            "ap.timeSlot.startDate >= :#{#filter.checkin} and " +
//            "ap.timeSlot.endDate <= :#{#filter.checkout})) and " +
//            "(:#{#filter.guestNum} is null or a.maxGuests >= :#{#filter.guestNum}) and " +
//            "(:#{#filter.type} is null or a.type = :#{#filter.type}) and " +
//            "(:#{#filter.amenities} is null or a.amenities IN :#{#filter.amenities}) and " +
//            "(:#{#filter.minRating} is null or " +
//            "COALESCE((SELECT AVG(r.rating) FROM AccommodationReview r WHERE r.reviewedAccommodation.id = a.id), 0) >= :#{#filter.minRating})")
//    HashSet<Accommodation> findAccommodationsByFilter(@Param("filter") AccommodationFilter filter);

}