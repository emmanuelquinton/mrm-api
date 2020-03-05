package org.equinton.mrm.domain.port;

import org.equinton.mrm.domain.model.Reservation;

public interface ReservationDomainService {

    Reservation save(Reservation reservation);
}
