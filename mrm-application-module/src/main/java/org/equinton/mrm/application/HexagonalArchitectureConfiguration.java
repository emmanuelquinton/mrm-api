package org.equinton.mrm.application;

import org.equinton.mrm.domain.adapter.ReservationAdapter;
import org.equinton.mrm.domain.port.ReservationDomainService;
import org.equinton.mrm.domain.port.ReservationRecord;
import org.equinton.mrm.storage.adapter.ReservationRecordAdapter;
import org.equinton.mrm.storage.repository.ReservationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class HexagonalArchitectureConfiguration  {


    @Bean
    public ReservationRecord reservationRecord(ReservationRepository reservationRepository) {
        return new ReservationRecordAdapter(reservationRepository);
    }

    @Bean
    public ReservationDomainService reservationDomainService(ReservationRecord reservationRecord) {
        return new ReservationAdapter(reservationRecord);
    }
}
