package org.example.controllers;

import org.example.dto.InstrumentDto;
import org.example.entity.Genre;
import org.example.entity.Instrument;
import org.example.services.InstrumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InstrumentController {

    private final InstrumentService service;

    public InstrumentController(InstrumentService service) {
        this.service = service;
    }

    @PostMapping("/instruments")
    public Instrument create(@RequestBody InstrumentDto.InstrumentCreateRequest instrumentCreateRequest){
        return service.create(instrumentCreateRequest);
    }

    @DeleteMapping("/instruments/{id}")
    public Optional<Instrument> delete(@RequestParam Integer id){
        return service.delete(id);
    }

    @GetMapping("/instruments/{id}")
    private Optional<Instrument> search(@RequestParam Integer id){
        return service.search(id);
    }

    @GetMapping("/instruments")
    public List<Instrument> getAll(){
        return service.getAll();
    }

}
