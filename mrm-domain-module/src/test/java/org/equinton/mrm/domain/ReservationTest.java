package org.equinton.mrm.domain;

import org.assertj.core.api.Assertions;
import org.equinton.mrm.domain.model.MeetingRoom;
import org.equinton.mrm.domain.model.Reservation;
import org.equinton.mrm.domain.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReservationTest {
    private User user;
    private MeetingRoom meetingRoom ;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    @BeforeAll
    static void  beforeAll() {
        User user = new User("sn012345", "john", "Doe");
        MeetingRoom meetingRoom =MeetingRoom.BREST;
        LocalDate date = LocalDate.parse("27/02/2020", DateTimeFormatter.ofPattern("dd/MM/yyy"));
        LocalTime startTime =  LocalTime.of(11,00);
        LocalTime endTime =  LocalTime.of(12,30);

    }


    @Test
    void should_reservation_has_got_a_user() {
        //when
        Reservation actualReservation = new Reservation(user, meetingRoom, date, startTime,  endTime);
        //then
        Assertions.assertThat(actualReservation.getUser()).isEqualTo(user);
    }

    @Test
    void should_reservation_has_got_a_meeting_room() {
        //when
        Reservation actualReservation = new Reservation(user, meetingRoom, date, startTime,  endTime);

        //then
        Assertions.assertThat(actualReservation.getMeetingRoom()).isEqualTo(user);
    }

    @Test
    void should_reservation_has_got_a_date() {
        //when
        Reservation actualReservation = new Reservation(user, meetingRoom, date, startTime,  endTime);

        //then
        Assertions.assertThat(actualReservation.getStartTime()).isEqualTo(startTime);
    }

    @Test
    void should_reservation_has_got_a_start_time() {
        //when
        Reservation actualReservation = new Reservation(user, meetingRoom, date, startTime,  endTime);

        //then
        Assertions.assertThat(actualReservation.getStartTime()).isEqualTo(startTime);
    }

    @Test
    void should_reservation_has_got_a_end_time() {
        //when
        Reservation actualReservation = new Reservation(user, meetingRoom, date, startTime,  endTime);

        //then
        Assertions.assertThat(actualReservation.getStartTime()).isEqualTo(endTime);
    }

}
