package org.example.controllers;

import jdk.dynalink.linker.LinkerServices;
import org.example.dto.GenreDto;
import org.example.entity.Genre;
import org.example.services.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreController {

    private final GenreService service;

    public GenreController(GenreService service) {
        this.service = service;
    }

    @GetMapping("/genres")
    public List<Genre> getAll(){
        return service.getAll();
    }

    @PostMapping("/genres")
    public Genre create(@RequestBody GenreDto.GenreCreateRequest genreCreateRequest){
        return service.create(genreCreateRequest);
    }

    @DeleteMapping("/genres/{id}")
    public Optional<Genre> delete(@RequestParam Integer id){
        return service.delete(id);
    }

    @GetMapping("/genres/{id}")
    public Optional<Genre> search(Integer id){
        return service.search(id);
    }
}
