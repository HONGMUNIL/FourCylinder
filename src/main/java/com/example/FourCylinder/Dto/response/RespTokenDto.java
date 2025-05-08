package com.example.FourCylinder.Dto.response;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RespTokenDto {
    private String type;
    private String name;
    private String token;


}
