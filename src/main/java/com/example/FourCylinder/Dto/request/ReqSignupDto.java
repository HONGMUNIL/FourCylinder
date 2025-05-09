package com.example.FourCylinder.Dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "회원가입 정보 DTO")
public class ReqSignupDto {
    @Schema(description = "사용자 이름")
    private String username;
    @Schema(description = "사용자 패스워드")
    private String password;
    @Schema(description = "사용자 닉네임")
    private String nickname;
    @Schema(description = "사용자 이메일")
    private String email;


}
