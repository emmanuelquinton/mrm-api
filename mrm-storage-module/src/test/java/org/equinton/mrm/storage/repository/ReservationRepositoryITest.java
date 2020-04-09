package org.equinton.mrm.storage.repository;

import org.assertj.core.api.Assertions;
import org.equinton.mrm.domain.model.MeetingRoom;
import org.equinton.mrm.storage.StorageTestConfiguration;
import org.equinton.mrm.storage.entity.ReservationEntity;
import org.equinton.mrm.storage.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalTime;

@DataJpaTest
public class ReservationRepositoryITest {

    @Autowired
    private ReservationRepository reserrvationRepository;




    @Test
    void should_record_reservation() {
        //given
        ReservationEntity reservationEntity = ReservationEntity.builder()
                .user(new UserEntity())
                .meetingRoom(MeetingRoom.BREST.name())
                .date(LocalDate.now())
                .startTime( LocalTime.of(11, 00))
                .endTime( LocalTime.of(12, 00))
                .build();
        //when
        ReservationEntity actualReservation = reserrvationRepository.save(reservationEntity);
        //then
        Assertions.assertThat(actualReservation.getId()).isNotNull();
    }

    @Test
    void should_recorded_reservation_has_id() {
        //given
        ReservationEntity reservationEntity = ReservationEntity.builder()
                .user(new UserEntity())
                .meetingRoom(MeetingRoom.MORLAIS.name())
                .date(LocalDate.now())
                .startTime( LocalTime.of(11, 00))
                .endTime( LocalTime.of(12, 00))
                .build();
        //when
        ReservationEntity actualReservation = reserrvationRepository.save(reservationEntity);
        //then
        Assertions.assertThat(actualReservation.getId()).isNotNull();
    }


}
