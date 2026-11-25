package org.example.db;

import org.example.entity.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentDB  extends JpaRepository<Instrument, Integer> {
}
