package org.example.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // или SINGLE_TABLE
@Table(name = "profiles")
public abstract class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;
    protected String owner;

    protected String name;
    protected String description;

    @ElementCollection
    private List<Instrument> instrument;

    @ElementCollection
    private List<Genre> genres;

    public UUID getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Profile(){}

}
