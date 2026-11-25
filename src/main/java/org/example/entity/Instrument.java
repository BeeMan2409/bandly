package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Entity
@Table(name = "instruments")
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 16)
    private String name;

    @Column(name = "type", length = 16)
    private String type;

    public Instrument(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
