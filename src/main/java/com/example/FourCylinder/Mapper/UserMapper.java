package com.example.FourCylinder.Mapper;

import com.example.FourCylinder.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insertUser(User user);
    User selectByUsername(String username);
}
