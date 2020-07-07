package org.equinton.mrm.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class User implements Serializable {
    private UUID id;
    private String serialNumber;
    private String firstName;
    private String lastName;

    public User(String serialNumber, String firstName, String lastName) {
        this.serialNumber = serialNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
