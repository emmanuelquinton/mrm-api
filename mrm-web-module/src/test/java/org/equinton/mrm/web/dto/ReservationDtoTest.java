package org.equinton.mrm.web.dto;

import org.assertj.core.api.Assertions;
import org.equinton.mrm.domain.model.MeetingRoom;
import org.equinton.mrm.domain.model.Reservation;
import org.equinton.mrm.domain.model.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class ReservationDtoTest {

    @Test
    void should_convert_reservation_dto_to_reservation() {
        //given
        LocalDate date = LocalDate.parse("27/02/2020", DateTimeFormatter.ofPattern("dd/MM/yyy"));
        LocalTime startTime = LocalTime.of(11, 00);
        LocalTime endTime = LocalTime.of(12, 30);

        String userId = UUID.randomUUID().toString();
        ReservationDto reservationDto = ReservationDto.builder()
                .userId(userId)
                .meetingRoom(MeetingRoom.MORLAIS.name())
                .date(date)
                .startTime(startTime)
                .endTime(endTime)
                .build();

        Reservation expectedReservation = Reservation.builder()
                .user(User.builder().id(UUID.fromString(userId)).build())
                .meetingRoom(MeetingRoom.MORLAIS)
                .date(date)
                .startTime(startTime)
                .endTime(endTime)
                .build();

        //when
        Reservation actualReservation = reservationDto.toReservation();

        //then
        Assertions.assertThat(actualReservation).isEqualTo(expectedReservation);
    }
}
