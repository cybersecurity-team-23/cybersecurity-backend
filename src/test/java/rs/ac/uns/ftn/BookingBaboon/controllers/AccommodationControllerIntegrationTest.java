package rs.ac.uns.ftn.BookingBaboon.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import rs.ac.uns.ftn.BookingBaboon.domain.accommodation_handling.Accommodation;
import rs.ac.uns.ftn.BookingBaboon.dtos.accommodation_handling.accommodation.AccommodationResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(
//        locations = "classpath:application-test.properties")
@ActiveProfiles("test")
public class AccommodationControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Should Get Accommodation by ID When making GET request to /api/v1/accommodations/{id}")
    public void shouldRetrieveAccommodationById() {
        Long accommodationId = 1L;

        ResponseEntity<AccommodationResponse> responseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/api/v1/accommodations/" + accommodationId,
                HttpMethod.GET,
                null,
                AccommodationResponse.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        AccommodationResponse accommodation = responseEntity.getBody();
        assertNotNull(accommodation);
        assertEquals(accommodation.getId(), accommodationId);
    }

    @Test
    @DisplayName("Should Get Total Price When making GET request to /api/v1/accommodations/{id}/total-price")
    public void shouldRetrieveTotalPrice() {
        Long accommodationId = 1L;

        String checkin = "2024-01-01";
        String checkout = "2024-01-05";

        ResponseEntity<Float> responseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/api/v1/accommodations/" + accommodationId + "/total-price" +
                        "?checkin=" + checkin +
                        "&checkout=" + checkout,
                HttpMethod.GET,
                null,
                Float.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Float totalPrice = responseEntity.getBody();
        assertNotNull(totalPrice);
        assertEquals(totalPrice, 320L);
    }

}
