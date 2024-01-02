package rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.BookingBaboon.domain.reservation.Reservation;
import rs.ac.uns.ftn.BookingBaboon.domain.shared.TimeSlot;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.summary.AccommodationMonthlySummary;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.summary.MonthlyData;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.summary.PeriodSummary;
import rs.ac.uns.ftn.BookingBaboon.services.accommodation_handling.interfaces.ISummaryService;
import rs.ac.uns.ftn.BookingBaboon.services.reservation.interfaces.IReservationService;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SummaryService implements ISummaryService {
    private final IReservationService reservationService;
    @Override
    public PeriodSummary getPeriodSummary(String hostId, Date startDate, Date endDate) {
        return new PeriodSummary();
    }

    @Override
    public AccommodationMonthlySummary getMonthlySummary(Long id) {
        AccommodationMonthlySummary summary = new AccommodationMonthlySummary();

        LocalDate currentDate = LocalDate.now();
        LocalDate dateOneYearAgo = currentDate.minusYears(1);
        Map<Month, Integer> reservationsData = new LinkedHashMap<>();
        Map<Month, Double> profitData = new LinkedHashMap<>();

        for (LocalDate date = dateOneYearAgo; date.isBefore(currentDate); date = date.plusMonths(1)) {
            int year = date.getYear();
            Month month = date.getMonth();

            Collection<Reservation> reservations = reservationService.getAllFinishedByAccommodationAndMonth(id, year, month.getValue());

            int reservationsCount = reservations.size();
            double totalProfit = reservations.stream().mapToDouble(Reservation::getPrice).sum();

            reservationsData.put(month, reservationsCount);
            profitData.put(month, totalProfit);
        }

        summary.setAccommodationId(id);
        summary.setTimeSlot(new TimeSlot(dateOneYearAgo, currentDate));
        summary.setReservationsData(reservationsData);
        summary.setProfitData(profitData);
        return summary;
    }
}
