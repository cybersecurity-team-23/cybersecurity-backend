package rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationFilter;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AccommodationType;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Amenity;

import java.util.*;


@Repository
public interface IAccommodationRepository extends JpaRepository<Accommodation, Long> {


    @Query("SELECT DISTINCT a FROM Accommodation a " +
            "WHERE (:#{#filter.city} IS NULL OR a.location.city = :#{#filter.city}) AND" +
            "(:#{#filter.guestNum} IS NULL OR a.minGuests <= :#{#filter.guestNum}) AND" +
            "(:#{#filter.guestNum} IS NULL OR a.maxGuests >= :#{#filter.guestNum}) AND" +
            "(:#{#filter.type} IS NULL OR a.type = :#{#filter.type}) AND" +
            "(:#{#filter.minRating} IS NULL OR (SELECT AVG(r.rating) FROM AccommodationReview r WHERE r.reviewedAccommodation.id = a.id) >= :#{#filter.minRating}) AND" +
            "(:#{#filter.amenities} IS NULL OR (SELECT COUNT(DISTINCT amenity.name) FROM a.amenities amenity WHERE amenity.name IN :#{#filter.amenities}) = :#{#filter.amenities?.size()})"
    )
    Set<Accommodation> findAccommodationsByFilter(
            @Param("filter") AccommodationFilter filter
//            @Param("city") String city,                   +
//            @Param("checkin") Date checkin,
//            @Param("checkout") Date checkout,
//            @Param("guestNum") Integer guestNum,          +
//            @Param("minPrice") Double minPrice,
//            @Param("maxPrice") Double maxPrice,
//            @Param("type") AccommodationType type,        +
//            @Param("amenities") Set<Amenity> amenities,   +
//            @Param("minRating") Double minRating          +
    );

}