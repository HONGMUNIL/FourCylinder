package com.example.FourCylinder.Mapper;

import com.example.FourCylinder.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectByUserId(String userId);
    int insertUser(User user);
}
