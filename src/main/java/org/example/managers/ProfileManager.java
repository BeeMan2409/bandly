package org.example.managers;

import org.example.entity.Band;
import org.example.entity.Musician;
import org.example.entity.Profile;
import org.example.db.ProfileDB;
import org.example.dto.ProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ProfileManager {

    private final ProfileDB profileDB;

    @Autowired
    public ProfileManager(ProfileDB profileDB) {
        this.profileDB = profileDB;
    }

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
