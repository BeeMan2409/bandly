package org.example.db;

import org.example.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreDB extends JpaRepository<Genre, Integer> {
}
