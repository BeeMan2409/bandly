package org.example.services;

import org.example.db.GenreDB;
import org.example.dto.GenreDto;
import org.example.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreService {

    private final GenreDB db;

    @Autowired
    public GenreService(GenreDB db) {
        this.db = db;
    }

    public List<Genre> getAll(){
        return db.findAll();
    }

    public Optional<Genre> search(Integer id){
        return db.findById(id);
    }

    public Optional<Genre> delete(Integer id){
        Optional<Genre> genre = db.findById(id);
        db.deleteById(id);
        return genre;
    }

    public Genre create(GenreDto.GenreCreateRequest genreCreateRequest){
        Genre genre = new Genre(genreCreateRequest.getName());
        return genre;
    }

}
