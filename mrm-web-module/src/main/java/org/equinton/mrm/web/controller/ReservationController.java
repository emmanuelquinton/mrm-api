package org.equinton.mrm.web.controller;

import org.equinton.mrm.domain.port.ReservationDomainService;
import org.equinton.mrm.web.dto.ReservationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class ReservationController {


    private ReservationDomainService reservationDomainService;

    public ReservationController(ReservationDomainService reservationDomainService) {
        this.reservationDomainService = reservationDomainService;
    }

    @PostMapping()
    public ResponseEntity<UUID> createReservation(@RequestBody ReservationDto reservation) {
        return ResponseEntity.ok(reservationDomainService.save(reservation.toReservation()).getId());
    }
}
