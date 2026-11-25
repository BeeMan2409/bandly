package org.example.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "tg", length = 33, nullable = true)
    private String tg;

    @Column(name = "name", length = 32, nullable = false)
    private String name;

    @Column(name = "password", length = 80, nullable = false)
    private String password;

    @ElementCollection
    private List<Profile> profiles;

    public User(){}

    public User(String tg, String name) {
        this.tg = tg;
        this.name = name;
    }
}
