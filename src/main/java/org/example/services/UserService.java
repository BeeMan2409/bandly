package org.example.services;

import org.example.entity.Genre;
import org.example.entity.User;
import org.example.db.UserDB;
import org.example.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private final UserDB db;

    @Autowired
    public UserService(UserDB db) {
        this.db = db;
    }

    public List<User> getAll(){
        return db.findAll();
    }

    public Optional<User> search(UUID id){
        return db.findById(id);
    }

    public User create(UserDto.UserCreateRequest userCreateRequest){
        User user = new User(userCreateRequest.getTg(), userCreateRequest.getName());
        db.save(user);
        return user;
    }

    public Optional<User> delete(UUID id){
        Optional<User> user = db.findById(id);
        db.deleteById(id);
        return user;
    }

}
