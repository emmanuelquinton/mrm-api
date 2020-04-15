package org.equinton.mrm.storage.repository;

import org.assertj.core.api.Assertions;
import org.equinton.mrm.domain.model.MeetingRoom;
import org.equinton.mrm.storage.entity.ReservationEntity;
import org.equinton.mrm.storage.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@DataJpaTest
public class UserRepositoryITest {

    @Autowired
    private UserRepository userRepository;


    @Test
    void should_record_user() {
        //given
        UserEntity userEntity = UserEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .serialNumber("id-01234")
                .build();
        //when
        UserEntity actualUserEntity = userRepository.save(userEntity);
        //then
        Assertions.assertThat(actualUserEntity).isNotNull();
    }

    @Test
    void should_recorded_user_has_id() {
        //given
        UserEntity userEntity = UserEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .serialNumber("id-01234")
                .build();
        //when
        UserEntity actualUserEntity = userRepository.save(userEntity);
        //then
        Assertions.assertThat(actualUserEntity.getId()).isNotNull();
    }


}
