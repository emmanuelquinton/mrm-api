package org.equinton.mrm.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.equinton.mrm.domain.model.MeetingRoom;
import org.equinton.mrm.domain.port.ReservationDomainService;
import org.equinton.mrm.web.dto.ReservationDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ReservationControllerTest {

    @LocalServerPort
    private int port;

    private String uri;

    @InjectMocks
    private ReservationController reservationController;

    @Mock
    private ReservationDomainService reservationDomainService;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    void should_post_reservation() throws JsonProcessingException {
        LocalDate date = LocalDate.parse("27/02/2020", DateTimeFormatter.ofPattern("dd/MM/yyy"));
        LocalTime startTime = LocalTime.of(11, 00);
        LocalTime endTime = LocalTime.of(12, 30);
        ObjectMapper mapper = new ObjectMapper();
        ReservationDto reservationDto = ReservationDto.builder()
                .userId(UUID.randomUUID().toString())
                .meetingRoom(MeetingRoom.MORLAIS.name())
                .date("27/02/2020")
                .startTime(startTime)
                .endTime(endTime)
                .build();
        String payload = mapper.writeValueAsString(reservationDto);

        given()
                .contentType(ContentType.JSON)
                .body(payload)
        .when()
                .post(uri + "/reservations")
        .then()
                .log().ifError()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void shoudl_call_save_method_of_domaine_service() throws JsonProcessingException {
        //given
        LocalDate date = LocalDate.parse("27/02/2020", DateTimeFormatter.ofPattern("dd/MM/yyy"));
        LocalTime startTime = LocalTime.of(11, 00);
        LocalTime endTime = LocalTime.of(12, 30);
        ReservationDto reservationDto = ReservationDto.builder()
                .userId(UUID.randomUUID().toString())
                .meetingRoom(MeetingRoom.BREST.name())
                .date("27/02/2020")
                .startTime(startTime)
                .endTime(endTime)
                .build();
        Mockito.when(reservationDomainService.save(reservationDto.toReservation()))
                .thenReturn(reservationDto.toReservation());

        //when
        reservationController.createReservation(reservationDto);

        //then
        Mockito.verify(reservationDomainService).save(reservationDto.toReservation());


    }
}
