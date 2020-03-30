package org.equinton.mrm.domain.model;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;

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

        if(this.endTime.isBefore(this.startTime)) {
            throw new IllegalArgumentException("The end time has to be after stat time");
        }

        if(Duration.between(startTime, endTime).toHours()> 10 ) {
            throw new IllegalArgumentException("The meetind has to have duration les or equals to 10 hours");
        }
    }
}
