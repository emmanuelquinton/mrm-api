package org.equinton.mrm.application;

import org.equinton.mrm.domain.adapter.ReservationAdapter;
import org.equinton.mrm.domain.adapter.UserAdapter;
import org.equinton.mrm.domain.port.ReservationDomainService;
import org.equinton.mrm.domain.port.ReservationRecord;
import org.equinton.mrm.domain.port.UserDomainService;
import org.equinton.mrm.domain.port.UserRecord;
import org.equinton.mrm.storage.adapter.ReservationRecordAdapter;
import org.equinton.mrm.storage.adapter.UserRecordAdapter;
import org.equinton.mrm.storage.repository.ReservationRepository;
import org.equinton.mrm.storage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HexagonalArchitectureConfiguration {


    @Bean
    public ReservationRecord reservationRecord(ReservationRepository reservationRepository) {
        return new ReservationRecordAdapter(reservationRepository);
    }

    @Bean
    public ReservationDomainService reservationDomainService(ReservationRecord reservationRecord) {
        return new ReservationAdapter(reservationRecord);
    }

    @Bean
    public UserRecord userRecord(UserRepository userRepository) {
        return new UserRecordAdapter(userRepository);
    }

    @Bean
    public UserDomainService userDomainService(UserRecord userRecord) {
        return new UserAdapter(userRecord);
    }
}
