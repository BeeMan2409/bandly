package org.example.services;

import org.example.entity.Band;
import org.example.entity.Musician;
import org.example.entity.Profile;
import org.example.db.ProfileDB;
import org.example.dto.ProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ProfileService {

    private final ProfileDB db;

    @Autowired
    public ProfileService(ProfileDB db) {
        this.db = db;
    }

    public List<Profile> getAll(){
        return db.findAll();
    }

    public ProfileDB getDb() {
        return db;
    }

    public Optional<Profile> search(UUID id){
        return db.findById(id);
    }

    public void delete(UUID id){
        db.deleteById(id);
    }

    public Profile create(ProfileDto.ProfileCreateRequest dto){
        Profile profile = switch (dto.getType()){
            case MUSICIAN ->new Musician();
            case BAND ->new Band();
        };
        profile.setName(dto.getName());
        profile.setDescription(dto.getDescription());
        profile.setOwner(dto.getOwner());
        db.save(profile);
        return profile;
    }
}
