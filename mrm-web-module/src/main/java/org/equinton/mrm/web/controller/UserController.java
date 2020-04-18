package org.equinton.mrm.web.controller;

import org.equinton.mrm.domain.port.UserDomainService;
import org.equinton.mrm.web.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private  UserDomainService userDomainService;

    public UserController(UserDomainService userDomainService) {
        this.userDomainService = userDomainService;
    }

    @PostMapping
    ResponseEntity<UUID> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userDomainService.save(userDto.toUser()).getId());
    }
}
