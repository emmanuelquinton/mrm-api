package org.equinton.mrm.domain.adapter;

import org.equinton.mrm.domain.model.Reservation;
import org.equinton.mrm.domain.port.ReservationDomainService;
import org.equinton.mrm.domain.port.ReservationRecord;

public class ReservationAdapter implements ReservationDomainService {
    private ReservationRecord reservationRecord;

    public ReservationAdapter(ReservationRecord reservationRecord) {
        this.reservationRecord = reservationRecord;
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRecord.save(reservation);
    }
}
