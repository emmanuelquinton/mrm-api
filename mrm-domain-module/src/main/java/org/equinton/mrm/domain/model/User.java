package org.equinton.mrm.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

    private String serialNumber;
    private String firstName;
    private String lastName;

    public User(String serialNumber, String firstName, String lastName) {
        this.serialNumber = serialNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
