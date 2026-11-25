package org.example.controllers;

import org.example.entity.Profile;
import org.example.dto.ProfileDto;
import org.example.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProfileController {

    private final ProfileService service;

    @Autowired
    public ProfileController(ProfileService service){
        this.service = service;
    }

    @GetMapping("/profiles/{id}")
    public Optional<Profile> getById(@PathVariable UUID id){
        return service.search(id);
    }

    @DeleteMapping("/profiles/{id}")
    void delete(@PathVariable UUID id){
        service.delete(id);
    }

    @PostMapping("/profiles")
    Profile create(@RequestBody ProfileDto.ProfileCreateRequest profileDto){
        return service.create(profileDto);
    }

    @GetMapping("/profiles")
    public List<Profile> getAll(){
        return service.getAll();
    }
}
