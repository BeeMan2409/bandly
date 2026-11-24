package org.example.db;

import org.example.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileDB extends JpaRepository<Profile, UUID> {
    void delete(Optional<Profile> profile);
}
