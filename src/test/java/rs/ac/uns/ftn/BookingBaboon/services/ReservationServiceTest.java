package rs.ac.uns.ftn.BookingBaboon.services.reservation;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.Notification;
import rs.ac.uns.ftn.BookingBaboon.domain.notifications.NotificationType;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.ReservationStatus;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.TimeSlot;
import rs.ac.uns.ftn.BookingBaboon.repositories.reservation_handling.IReservationRepository;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.IAccommodationService;
import rs.ac.uns.ftn.BookingBaboon.services.notifications.INotificationService;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IUserService;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class ReservationServiceTest {

    @Autowired
    private ReservationService reservationService;

    @MockBean
    private IAccommodationService accommodationService;

    @MockBean
    private INotificationService notificationService;

    @MockBean
    private IReservationRepository reservationRepository;

    @MockBean
    private IUserService userService;

    @Test
    public void testCreateValidReservation() {
        Accommodation accommodation = new Accommodation();
        accommodation.setId(1L);

        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setAccommodation(accommodation);
        reservation.setTimeSlot(new TimeSlot(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));

        when(accommodationService.get(reservation.getAccommodation().getId())).thenReturn(accommodation);

        Reservation result = reservationService.create(reservation);

        assertNotNull(result);
        assertEquals(ReservationStatus.Pending, result.getStatus());

        verify(accommodationService, times(1)).get(reservation.getAccommodation().getId());
        verify(notificationService, times(1)).create(any(Notification.class));
    }

    @Test
    public void testCreateInvalidReservation() {
        Accommodation accommodation = new Accommodation();
        accommodation.setId(1L);

        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setAccommodation(accommodation);
        reservation.setTimeSlot(new TimeSlot(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));

        when(accommodationService.get(reservation.getAccommodation().getId())).thenReturn(accommodation);

        doThrow(new ConstraintViolationException("Some constraint violation", new HashSet<>())).when(reservationRepository).save(reservation);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> reservationService.create(reservation));

        assertEquals(HttpStatus.NOT_ACCEPTABLE.value(), exception.getStatusCode().value());
        assertTrue(exception.getReason().contains("Some constraint violation"));

        verify(accommodationService, times(1)).get(reservation.getAccommodation().getId());
        verify(notificationService, never()).create(any(Notification.class));
    }

    @Test
    public void testHandleAutomaticAcceptanceAutomaticallyAccepted() {
        Accommodation accommodation = new Accommodation();
        accommodation.setId(1L);
        accommodation.setIsAutomaticallyAccepted(true);

        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setAccommodation(accommodation);

        when(accommodationService.get(reservation.getAccommodation().getId())).thenReturn(accommodation);

        Reservation result = reservationService.handleAutomaticAcceptance(reservation);

        assertNotNull(result);
        assertEquals(ReservationStatus.Approved, result.getStatus());

        verify(accommodationService, times(1)).get(reservation.getAccommodation().getId());
    }

    @Test
    public void testHandleAutomaticAcceptanceNotAutomaticallyAccepted() {
        Accommodation accommodation = new Accommodation();
        accommodation.setId(1L);
        accommodation.setIsAutomaticallyAccepted(false);

        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setAccommodation(accommodation);

        when(accommodationService.get(reservation.getAccommodation().getId())).thenReturn(accommodation);

        Reservation result = reservationService.handleAutomaticAcceptance(reservation);

        assertNotNull(result);
        assertEquals(ReservationStatus.Pending, result.getStatus());

        verify(accommodationService, times(1)).get(reservation.getAccommodation().getId());
    }
}
