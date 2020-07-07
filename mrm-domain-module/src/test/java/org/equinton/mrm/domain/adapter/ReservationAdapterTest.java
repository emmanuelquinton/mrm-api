package org.equinton.mrm.domain.adapter;

import org.equinton.mrm.domain.model.MeetingRoom;
import org.equinton.mrm.domain.model.Reservation;
import org.equinton.mrm.domain.model.User;
import org.equinton.mrm.domain.port.ReservationRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//@ExtendWith(MockitoExtension.class)
public class ReservationAdapterTest {

    @InjectMocks
    private ReservationAdapter reservationDomainService;

    @Mock
    private ReservationRecord reservationRecord;


    //@Test
    void should_call_save_method_of_resevationRecord() {
        //given
        User user = new User("sn012345", "john", "Doe");
        MeetingRoom meetingRoom = MeetingRoom.BREST;
        LocalDate date = LocalDate.parse("27/02/2020", DateTimeFormatter.ofPattern("dd/MM/yyy"));
        LocalTime startTime = LocalTime.of(11, 00);
        LocalTime endTime = LocalTime.of(12, 30);

        Reservation reservation = new Reservation(user, meetingRoom, date, startTime, endTime);
        Mockito.when(reservationRecord.save(reservation)).thenReturn(reservation);
        //when
        reservationDomainService.save(reservation);
        //then
        Mockito.verify(reservationRecord).save(reservation);
    }

}
