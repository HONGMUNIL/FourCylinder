package com.example.FourCylinder.Controller;


import com.example.FourCylinder.Dto.request.ReqLoginDto;
import com.example.FourCylinder.Dto.request.ReqSignupDto;
import com.example.FourCylinder.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Operation(summary = "회원가입", description = "회원가입설명")
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody ReqSignupDto dto) {
        return ResponseEntity.ok().body(userService.signup(dto));
    }

    @Operation(summary = "로그인", description = "로그인설명")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ReqLoginDto dto) {
        return ResponseEntity.ok().body(userService.login(dto));
    }



}
