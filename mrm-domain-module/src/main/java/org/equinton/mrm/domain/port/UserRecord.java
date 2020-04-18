package org.equinton.mrm.domain.port;

import org.equinton.mrm.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRecord {

    User save(User user);

}
