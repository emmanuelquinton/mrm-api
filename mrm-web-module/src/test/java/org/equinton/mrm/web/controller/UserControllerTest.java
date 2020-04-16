package org.equinton.mrm.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.equinton.mrm.domain.model.User;
import org.equinton.mrm.domain.port.UserDomainService;
import org.equinton.mrm.web.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import javax.annotation.PostConstruct;
import java.util.UUID;

import static io.restassured.RestAssured.given;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @InjectMocks
    private UserController usernController;

    @Mock
    private UserDomainService userDomainService;



    @Test
    void should_post_user() throws JsonProcessingException {
        UserDto userToSave = UserDto.builder()
                .firstName("John")
                .lastName("Doe")
                .serialNumber("ld-015987")
                .build();
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(userToSave);

        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(uri + "/users")
                .then()
                .log().ifError()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void shoudl_call_save_method_of_domaine_service() throws JsonProcessingException {
        //given
        UserDto userDtoToSave = UserDto.builder()
                .firstName("John")
                .lastName("Doe")
                .serialNumber("ld-015987")
                .build();


        User userToSave = userDtoToSave.toUser();
        User savedUser = User.builder()
                .id(UUID.randomUUID())
                .firstName("John")
                .lastName("Doe")
                .serialNumber("ld-015987")
                .build();
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(userDtoToSave);
        Mockito.when(userDomainService.save(userToSave))
                .thenReturn(savedUser);

        //when
        usernController.createUser(userDtoToSave);

        //then
        Mockito.verify(userDomainService).save(userToSave);


    }
}
