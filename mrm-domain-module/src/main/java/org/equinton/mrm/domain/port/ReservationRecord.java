package org.equinton.mrm.domain.port;

import org.equinton.mrm.domain.model.Reservation;

public interface ReservationRecord {

    Reservation save(Reservation reservation);
}
