package org.equinton.mrm.storage.adapter;

import org.equinton.mrm.domain.model.MeetingRoom;
import org.equinton.mrm.domain.model.Reservation;
import org.equinton.mrm.domain.model.User;
import org.equinton.mrm.storage.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservationRecordAdapterTest {

    @InjectMocks
    ReservationRecordAdapter reservationRecordAdapter;

    @Mock
    ReservationRepository reservationRepository;

    @Test
    void should_save_method_call_repository_save_method() {
        //given
        User user = new User("sn012345", "john", "Doe");
        MeetingRoom meetingRoom = MeetingRoom.BREST;
        LocalDate date = LocalDate.parse("27/02/2020", DateTimeFormatter.ofPattern("dd/MM/yyy"));
        LocalTime startTime = LocalTime.of(11, 00);
        LocalTime endTime = LocalTime.of(12, 30);

        Reservation reservationToSave = new Reservation(user, meetingRoom, date, startTime, endTime);

        //when
       // Reservation actualReservation = reservationRecordAdapter.save(reservationToSave);

        //then
      //  verify(reservationRepository).save(any());

    }
}
