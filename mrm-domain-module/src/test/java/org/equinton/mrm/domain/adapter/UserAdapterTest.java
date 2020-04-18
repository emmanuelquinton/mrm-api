package org.equinton.mrm.domain.adapter;

import org.equinton.mrm.domain.model.MeetingRoom;
import org.equinton.mrm.domain.model.Reservation;
import org.equinton.mrm.domain.model.User;
import org.equinton.mrm.domain.port.ReservationRecord;
import org.equinton.mrm.domain.port.UserDomainService;
import org.equinton.mrm.domain.port.UserRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserAdapterTest {

    @InjectMocks
    private UserAdapter userDomainService;

    @Mock
    private UserRecord userRecord;


    @Test
    void should_call_save_method_of_userRecord() {
        //given
        User user = new User("sn012345", "john", "Doe");
        when(userRecord.save(user)).thenReturn(user);

        //when
        userDomainService.save(user);
        //then
        Mockito.verify(userRecord).save(user);
    }

}
