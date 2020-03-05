package org.equinton.mrm.domain.port;

import org.equinton.mrm.domain.model.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRecord {

    Reservation save(Reservation reservation);
}
