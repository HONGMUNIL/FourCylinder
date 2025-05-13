package com.example.FourCylinder.Service;

import com.example.FourCylinder.Dto.request.ReqLoginDto;
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

    public User login(ReqLoginDto reqLoginDto) {
        User user = userRepository
                .findByUsername(reqLoginDto.getUsername())
                .orElseThrow(() -> new RuntimeException("사용자 정보를 다시 확인하세요."));

        if (!user.getPassword().equals(reqLoginDto.getPassword())) {
            throw new RuntimeException("사용자 정보를 다시 확인하세요.");
        }
        return user;
    }

}
