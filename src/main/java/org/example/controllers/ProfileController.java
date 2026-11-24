package org.example.controllers;

import org.example.Profile;
import org.example.dto.ProfileDto;
import org.example.managers.ProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class ProfileController {

    @Autowired
    private ProfileManager profileManager;

    @GetMapping("/profiles/{id}")
    public Optional<Profile> getById(@PathVariable UUID id){
        return profileManager.search(id);
    }

    @DeleteMapping("/profiles/{id}")
    void delete(@PathVariable UUID id){
        profileManager.delete(id);
    }

    @PostMapping("/profiles")
    Profile create(@RequestBody ProfileDto.ProfileCreateRequest profileDto){
        return profileManager.create(profileDto);
    }
}
