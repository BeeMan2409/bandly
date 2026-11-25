package org.example.managers;

import org.example.db.InstrumentDB;
import org.example.dto.InstrumentDto;
import org.example.entity.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class InstrumentService {

    private final InstrumentDB db;

    @Autowired
    public InstrumentService(InstrumentDB db) {
        this.db = db;
    }

    public Instrument create(InstrumentDto.InstrumentCreateRequest instrumentCreateRequest){
        Instrument instrument = new Instrument(instrumentCreateRequest.getName(), instrumentCreateRequest.getType());
        db.save(instrument);
        return instrument;
    }

    public Optional<Instrument> delete(Integer id){
        Optional<Instrument> instrument = db.findById(id);
        db.deleteById(id);
        return instrument;
    }

    public Optional<Instrument> search(Integer id){
        Optional<Instrument> instrument = db.findById(id);
        return instrument;
    }

}
