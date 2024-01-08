package rs.ac.uns.ftn.BookingBaboon.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.AvailablePeriod;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.TimeSlot;
import rs.ac.uns.ftn.BookingBaboon.repositories.accommodation_handling.IAccommodationRepository;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.AccommodationService;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class AccommodationServiceTest {

    @Autowired
    private IAccommodationService accommodationService;

    @MockBean
    private IAccommodationRepository accommodationRepository;

    @MockBean
    private ResourceBundle bundle;
    @Test
    public void testParseDateValidInput() {
        LocalDate result = accommodationService.parseDate("2024-01-01");

        assertEquals(LocalDate.of(2024, 1, 1), result);
    }

    @Test
    public void testParseDateNullInput() {
        LocalDate result = accommodationService.parseDate(null);

        assertNull(result);
    }

    @Test
    public void testParseDateInvalidInput() {
        when(bundle.getString("invalidDateFormat")).thenReturn("Invalid date format");

        assertThrows(ResponseStatusException.class, () -> accommodationService.parseDate("invalid-date"));
    }

    @Test
    public void testGetExistingAccommodation() {
        Accommodation accommodation = new Accommodation();
        accommodation.setId(1L);

        when(accommodationRepository.findById(accommodation.getId())).thenReturn(Optional.of(accommodation));

        Accommodation result = accommodationService.get(accommodation.getId());

        assertEquals(accommodation, result);

        verify(accommodationRepository, times(1)).findById(accommodation.getId());
    }

    @Test
    public void testGetNonExistingAccommodation() {
        long nonExistingId = 999L;

        when(accommodationRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        when(bundle.getString("accommodation.notFound")).thenReturn("Accommodation not found");

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> accommodationService.get(nonExistingId));
        assertEquals("Accommodation not found", exception.getReason());

        verify(accommodationRepository, times(1)).findById(nonExistingId);
    }

    @Test
    public void testGetTotalPrice() {
        Accommodation accommodation = new Accommodation();
        accommodation.setId(1L);

        TimeSlot desiredPeriod = new TimeSlot(
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 1, 5)
        );

        List<AvailablePeriod> availablePeriods = Arrays.asList(
                new AvailablePeriod(1L, new TimeSlot(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 2)), 50F),
                new AvailablePeriod(2L, new TimeSlot(LocalDate.of(2024, 1, 2), LocalDate.of(2024, 1, 4)), 60F),
                new AvailablePeriod(3L, new TimeSlot(LocalDate.of(2024, 1, 4), LocalDate.of(2024, 1, 5)), 70F)
        );

        when(accommodationRepository.findAvailablePeriodsSortedByStartDate(accommodation.getId())).thenReturn(availablePeriods);

        float totalPrice = accommodationService.getTotalPrice(accommodation, desiredPeriod);

        assertEquals(320, totalPrice);

        verify(accommodationRepository, times(1)).findAvailablePeriodsSortedByStartDate(accommodation.getId());
    }
}
