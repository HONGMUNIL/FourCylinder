package com.example.FourCylinder.Service;

import com.example.FourCylinder.Dto.request.ReqSignupDto;
import com.example.FourCylinder.Entity.User;
import com.example.FourCylinder.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User signup(ReqSignupDto reqSignupDto) {
        User user = User.builder()
                .username(reqSignupDto.getUsername())
                .password(reqSignupDto.getPassword())
                .nickname(reqSignupDto.getNickname())
                .email(reqSignupDto.getEmail())
                .build();

       return userRepository.saveUser(user);
    }


}
