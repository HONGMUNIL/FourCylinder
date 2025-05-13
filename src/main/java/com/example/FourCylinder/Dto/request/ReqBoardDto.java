package com.example.FourCylinder.Dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "게시글 생성 DTO")
public class ReqBoardDto {
    private String title;
    private String content;
    private String author;


}
