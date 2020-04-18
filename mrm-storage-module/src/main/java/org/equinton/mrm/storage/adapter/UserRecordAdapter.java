package org.equinton.mrm.storage.adapter;

import org.equinton.mrm.domain.model.User;
import org.equinton.mrm.domain.port.UserRecord;
import org.equinton.mrm.storage.UserMapper;
import org.equinton.mrm.storage.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRecordAdapter implements UserRecord {
    private final UserRepository userRepository;

    public UserRecordAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User reservation) {
        return userRepository.save(UserMapper.INSTANCE.toEntity(reservation)).toUser();
    }
}
