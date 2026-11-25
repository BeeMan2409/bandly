package org.example.managers;

import org.example.entity.User;
import org.example.db.UserDB;
import org.example.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserManager {

    private final UserDB userDB;

    @Autowired
    public UserManager(UserDB userDB) {
        this.userDB = userDB;
    }

    public Optional<User> search(UUID id){
        return userDB.findById(id);
    }

    public User create(UserDto.UserCreateRequest userCreateRequest){
        User user = new User(userCreateRequest.getTg(), userCreateRequest.getName());
        userDB.save(user);
        return user;
    }

    public Optional<User> delete(UUID id){
        Optional<User> user = userDB.findById(id);
        userDB.delete(user);
        return user;
    }

}
