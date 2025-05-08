package com.example.FourCylinder.Service;

import com.example.FourCylinder.Dto.request.ReqLoginDto;
import com.example.FourCylinder.Entity.User;
import com.example.FourCylinder.Repository.UserRepository;
import com.example.FourCylinder.Security.Jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    private User user;
    private UserRepository userRepository;
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder passwordEncoder;

    public String login(ReqLoginDto dto) {
        User user = userRepository
                .findByUsername(dto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("사용자 정보를 다시 확인하세요."));

        if(!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 다시 확인하세요.");
        }
        // 이메일 인증 여부 확인
        if(user.getAccountEnabled() == 0) {
            throw new DisabledException("이메일 인증이 필요합니다.");
        }

        Date expires = new Date(new Date().getTime() + (1000l * 60 * 60 * 24 * 7));

        return jwtUtil.generateToken(
                user.getUsername(),
                Integer.toString(user.getUserId()),
                expires);
    }


}
