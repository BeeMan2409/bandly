package org.example.controllers;

import org.example.dto.GenreDto;
import org.example.entity.Genre;
import org.example.managers.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GenreController {

    private final GenreService service;

    public GenreController(GenreService service) {
        this.service = service;
    }

    @PostMapping("/genre")
    public Genre create(@RequestBody GenreDto.GenreCreateRequest genreCreateRequest){
        return service.create(genreCreateRequest);
    }

    @DeleteMapping("/genre/{id}")
    public Optional<Genre> delete(@RequestParam Integer id){
        return service.delete(id);
    }

    @GetMapping("/genre/{id}")
    public Optional<Genre> search(Integer id){
        return service.search(id);
    }
}
