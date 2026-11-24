package org.example.db;

import org.example.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDB extends JpaRepository<User, UUID> {
}
