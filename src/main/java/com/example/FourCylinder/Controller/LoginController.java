package com.example.FourCylinder.Controller;


import com.example.FourCylinder.Dto.request.ReqLoginDto;
import com.example.FourCylinder.Dto.response.RespTokenDto;
import com.example.FourCylinder.Security.Jwt.JwtUtil;
import com.example.FourCylinder.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public LoginController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @Operation(summary = "로그인", description = "로그인 설명")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ReqLoginDto dto) {
        /**
         * UserService -> login()
         * User객체 findByUsername
         * user가 있으면 비밀번호 일치하는지 확인
         * 비밀번호가 일치하면 JWT 응답
         * JwtUtil -> secret 세팅
         *
         */
        RespTokenDto respTokenDto = RespTokenDto.builder()
                .type("JWT")
                .name("AccessToken")
                .token(userService.login(dto))
                .build();

        return ResponseEntity.ok().body(respTokenDto);
    }






}
