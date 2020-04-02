package org.equinton.mrm.web;

import org.equinton.mrm.domain.adapter.ReservationAdapter;
import org.equinton.mrm.domain.model.Reservation;
import org.equinton.mrm.domain.port.ReservationDomainService;
import org.equinton.mrm.domain.port.ReservationRecord;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@EnableAutoConfiguration
public class WebTestConfiguration extends WebConfiguration {


    @Bean
    ReservationRecord reservationRecord() {
        return new ReservationAdapterImpl();
    }

    @Bean
    ReservationDomainService reservationDomainService(ReservationRecord reservationRecord) {
        return new ReservationAdapter(reservationRecord);
    }

    private class ReservationAdapterImpl implements ReservationRecord {

        @Override
        public Reservation save(Reservation reservation) {

            return reservation;
        }
    }
}
