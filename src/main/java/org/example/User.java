package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
public class User {

    @Id
    private String id = String.valueOf(100000000 + (int)(Math.random() * ((99999999 - 100000000) + 1)));;
    private String user_Tg;

    private String name;
    private int age;
    private List<Profile> profiles;

    public User(){}

}
