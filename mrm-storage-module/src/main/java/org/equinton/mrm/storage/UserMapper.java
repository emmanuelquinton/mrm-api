package org.equinton.mrm.storage;

import org.equinton.mrm.domain.model.User;
import org.equinton.mrm.storage.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDomainObject(UserEntity entity);

    UserEntity toEntity(User domainObject);

}