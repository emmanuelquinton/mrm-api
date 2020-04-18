package org.equinton.mrm.domain.port;

import org.equinton.mrm.domain.model.User;

public interface UserDomainService {

    User save(User user);
}
