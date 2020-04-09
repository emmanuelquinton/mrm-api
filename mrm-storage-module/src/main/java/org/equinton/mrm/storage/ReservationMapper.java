package org.equinton.mrm.storage;

import org.equinton.mrm.domain.model.MeetingRoom;
import org.equinton.mrm.domain.model.Reservation;
import org.equinton.mrm.storage.entity.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper  {

    ReservationMapper INSTANCE = Mappers.getMapper( ReservationMapper.class );


    Reservation toDomainObject(ReservationEntity entity);

    ReservationEntity toEntity(Reservation domainObject);

   default String toString(MeetingRoom meetingRoom) {
        return meetingRoom.name();
    }

    default MeetingRoom toString(String meetingRoomName) {
        return MeetingRoom.valueOf(meetingRoomName);
    }
}