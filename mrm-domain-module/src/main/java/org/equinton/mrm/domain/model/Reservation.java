package org.equinton.mrm.domain.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Reservation {
    private final User user;
    private MeetingRoom meetingRoom;
    private LocalTime startTime;
    private LocalTime endTime;

    public Reservation(User user, MeetingRoom meetingRoom, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.user = user;
        this.meetingRoom = meetingRoom;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
