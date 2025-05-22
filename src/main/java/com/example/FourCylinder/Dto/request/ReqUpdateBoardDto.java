package com.example.FourCylinder.Dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqUpdateBoardDto {
    private int boardId;
    private String title;
    private String content;

}
