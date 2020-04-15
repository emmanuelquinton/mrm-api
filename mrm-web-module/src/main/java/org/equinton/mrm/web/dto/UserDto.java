package org.equinton.mrm.web.dto;

import lombok.*;
import org.equinton.mrm.domain.model.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private String firstName;
    private String lastName;
    private String serialNumber;

    public User toUser() {
        return User.builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .serialNumber(this.serialNumber)
                .build();
    }
}
