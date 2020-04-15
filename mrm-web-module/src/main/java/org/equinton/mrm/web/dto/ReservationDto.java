package org.equinton.mrm.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.*;
import org.equinton.mrm.domain.model.MeetingRoom;
import org.equinton.mrm.domain.model.Reservation;
import org.equinton.mrm.domain.model.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private String userId;
    private String meetingRoom;
    private String date ;
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    private LocalTime startTime;
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    private LocalTime endTime;

    public Reservation toReservation() {
        return Reservation.builder()
                .meetingRoom(MeetingRoom.valueOf(meetingRoom))
                .user(User.builder().id(UUID.fromString(userId)).build())
                .date( LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyy")))
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
