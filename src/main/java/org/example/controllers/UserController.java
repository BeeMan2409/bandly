package org.example.controllers;

import org.example.entity.User;
import org.example.dto.UserDto;
import org.example.managers.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    private final UserManager userManager;

    @Autowired
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping("/user/{id}")
    public Optional<User> search(@RequestParam UUID id){
        return userManager.search(id);
    }

    @PostMapping("/user")
    public User create(@RequestBody UserDto.UserCreateRequest userCreateRequest){
        return userManager.create(userCreateRequest);
    }

    @DeleteMapping("/user/{id}")
    public Optional<User> delete(@RequestParam UUID id){
        return userManager.delete(id);
    }
}
