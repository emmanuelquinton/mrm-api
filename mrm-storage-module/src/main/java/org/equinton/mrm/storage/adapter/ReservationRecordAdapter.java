package org.equinton.mrm.storage.adapter;

import org.equinton.mrm.domain.model.Reservation;
import org.equinton.mrm.domain.port.ReservationRecord;
import org.equinton.mrm.storage.ReservationMapper;
import org.equinton.mrm.storage.repository.ReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationRecordAdapter implements ReservationRecord {
    private final ReservationRepository reservationRepository;

    public ReservationRecordAdapter(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(ReservationMapper.INSTANCE.toEntity(reservation)).toReservation();
    }
}
