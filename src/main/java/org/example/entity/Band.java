package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bands")
public class Band extends Profile {

    public Band(){}

}
