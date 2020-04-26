package org.equinton.mrm.domain.port;

import org.equinton.mrm.domain.model.User;

public interface UserRecord {

    User save(User user);

}
