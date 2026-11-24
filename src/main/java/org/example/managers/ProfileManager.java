package org.example.managers;

import org.example.Band;
import org.example.Musician;
import org.example.Profile;
import org.example.db.ProfileDB;
import org.example.dto.ProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static org.example.dto.ProfileDto.ProfileCreateRequest.Type.BAND;
import static org.example.dto.ProfileDto.ProfileCreateRequest.Type.MUSICIAN;

@Service
public class ProfileManager {

    @Autowired
    private ProfileDB profileDB;

    public ProfileDB getProfileDB() {
        return profileDB;
    }

    @Transactional
    public Optional<Profile> search(UUID id){
        return profileDB.findById(id);
    }

    @Transactional
    public void delete(UUID id){
        profileDB.deleteById(id);
    }

    @Transactional
    public Profile create(ProfileDto.ProfileCreateRequest dto){
        Profile profile = switch (dto.getType()){
            case MUSICIAN ->new Musician();
            case BAND ->new Band();
        };
        profile.setName(dto.getName());
        profile.setDescription(dto.getDescription());
        profile.setOwner(dto.getOwner());
        profileDB.save(profile);
        return profile;
    }
}
