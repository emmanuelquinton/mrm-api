package org.equinton.mrm.domain.model;

import org.assertj.core.api.Assertions;
import org.equinton.mrm.domain.model.MeetingRoom;
import org.equinton.mrm.domain.model.Reservation;
import org.equinton.mrm.domain.model.User;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReservationTest {
    private User user;
    private MeetingRoom meetingRoom;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    @BeforeEach
     void beforeEach() {
        user = new User("sn012345", "john", "Doe");
        meetingRoom = MeetingRoom.BREST;
        date = LocalDate.parse("27/02/2020", DateTimeFormatter.ofPattern("dd/MM/yyy"));
        startTime = LocalTime.of(11, 00);
        endTime = LocalTime.of(12, 30);

    }

    @Nested
    @DisplayName("Validation of the First Rule : the mandatory field of a reservation")
    class ConstructorWithAllArgTest {

        @Test
        void should_reservation_has_got_a_user() {
            //when
            Reservation actualReservation = new Reservation(user, meetingRoom, date, startTime, endTime);
            //then
            Assertions.assertThat(actualReservation.getUser()).isEqualTo(user);
        }

        @Test
        void should_reservation_has_got_a_meeting_room() {
            //when
            Reservation actualReservation = new Reservation(user, meetingRoom, date, startTime, endTime);

            //then
            Assertions.assertThat(actualReservation.getMeetingRoom()).isEqualTo(meetingRoom);
        }

        @Test
        void should_reservation_has_got_a_date() {
            //when
            Reservation actualReservation = new Reservation(user, meetingRoom, date, startTime, endTime);

            //then
            Assertions.assertThat(actualReservation.getStartTime()).isEqualTo(startTime);
        }

        @Test
        void should_reservation_has_got_a_start_time() {
            //when
            Reservation actualReservation = new Reservation(user, meetingRoom, date, startTime, endTime);

            //then
            Assertions.assertThat(actualReservation.getStartTime()).isEqualTo(startTime);
        }

        @Test
        void should_reservation_has_got_a_end_time() {
            //when
            Reservation actualReservation = new Reservation(user, meetingRoom, date, startTime, endTime);

            //then
            Assertions.assertThat(actualReservation.getEndTime()).isEqualTo(endTime);
        }
    }


    @Test
    @DisplayName("end time should be gretter than start time")
    void should_contructor_throw_exception_when_end_time_is_before_start_time () {
        //when
        Assertions.assertThatThrownBy(() ->    new Reservation(user, meetingRoom, date, endTime, startTime))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The end time has to be after stat time");
    }


    @Test
    @DisplayName("meetind could has duration less to 10 hours")
    void should_meeting_could_has_duration_less_to_10_hours () {
        //given
        LocalTime startTime =  LocalTime.of(8, 00); ;
        LocalTime endTime =  LocalTime.of(8, 00); ;;

        //when
       new Reservation(user, meetingRoom, date, startTime, endTime);
    }

    @Test
    @DisplayName("meetind could has duration equals to 10 hours")
    void should_meeting_could_has_duration_equals_to_10_hours () {
        //given
        LocalTime startTime =  LocalTime.of(8, 00); ;
        LocalTime endTime =  LocalTime.of(18, 00); ;;

        //when
        new Reservation(user, meetingRoom, date, startTime, endTime);
    }

    @Test
    @DisplayName("meetind could has duration equals to 10 hours")
    void should_meeting_could_not_has_duration_gretter_than_10_hours () {
        //given
        LocalTime startTime =  LocalTime.of(8, 00); ;
        LocalTime endTime =  LocalTime.of(19, 00); ;;

        //when
        Assertions.assertThatThrownBy(() ->    new Reservation(user, meetingRoom, date, startTime, endTime))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The meetind has to have duration les or equals to 10 hours");
    }

}
