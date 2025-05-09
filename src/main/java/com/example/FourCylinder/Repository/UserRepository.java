package com.example.FourCylinder.Repository;


import com.example.FourCylinder.Entity.User;
import com.example.FourCylinder.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserMapper userMapper;

    public User saveUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

}
