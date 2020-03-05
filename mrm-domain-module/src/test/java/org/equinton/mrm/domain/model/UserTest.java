package org.equinton.mrm.domain.model;

import org.assertj.core.api.Assertions;
import org.equinton.mrm.domain.model.User;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void should_user_have_got_serial_number() {
        // given
        String serialNumber = "m05833";
        User user = new User(serialNumber, "John", "doe");
        //when
        String actualMatricule = user.getSerialNumber();
        //then
        Assertions.assertThat(actualMatricule).isEqualTo(serialNumber);
    }

    @Test
    void should_user_have_got_last_name() {
        // given
        String serialNumber = "m05833";
        String firstName = "John";
        String lastName = "doe";
        User user = new User(serialNumber, firstName, lastName);
        //when
        String actualLastName = user.getLastName();
        //then
        Assertions.assertThat(actualLastName).isEqualTo(lastName);
    }

    @Test
    void should_user_have_got_first_name() {
        // given
        String serialNumber = "m05833";
        String firstName = "John";
        String lastName = "doe";
        User user = new User(serialNumber, firstName, lastName);
        //when
        String actualFirstName = user.getFirstName();
        //then
        Assertions.assertThat(actualFirstName).isEqualTo(firstName);
    }
}
