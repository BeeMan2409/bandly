package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "musicians")
public class Musician extends Profile {

    public Musician(){}

}
