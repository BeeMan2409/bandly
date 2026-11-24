package org.example;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;
    private String user_Tg;

    private String name;
    private int age;
    @ElementCollection
    private List<Profile> profiles;

    public User(){}

}
