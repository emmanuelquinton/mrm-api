package org.equinton.mrm.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.equinton.mrm")
@EntityScan("org.equinton.mrm.storage.*")
public class MeetingRoomsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingRoomsManagementApplication.class, args);
    }


}
