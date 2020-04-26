package org.equinton.mrm.domain.adapter;

import org.equinton.mrm.domain.model.User;
import org.equinton.mrm.domain.port.UserDomainService;
import org.equinton.mrm.domain.port.UserRecord;

public class UserAdapter implements UserDomainService {
    private UserRecord userRecord;

    public UserAdapter(UserRecord userRecord) {
        this.userRecord = userRecord;
    }

    @Override
    public User save(User user) {
        return userRecord.save(user);
    }
}
