package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bands")
public class Band extends Profile {

    public Band(){}

}
