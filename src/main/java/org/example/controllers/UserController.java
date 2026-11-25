package org.example.controllers;

import org.example.entity.User;
import org.example.dto.UserDto;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users/{id}")
    public Optional<User> search(@RequestParam UUID id){
        return service.search(id);
    }

    @PostMapping("/users")
    public User create(@RequestBody UserDto.UserCreateRequest userCreateRequest){
        return service.create(userCreateRequest);
    }

    @DeleteMapping("/users/{id}")
    public Optional<User> delete(@RequestParam UUID id){
        return service.delete(id);
    }

    @GetMapping("/users")
    public List<User> getAll(){
        return service.getAll();
    }
}
