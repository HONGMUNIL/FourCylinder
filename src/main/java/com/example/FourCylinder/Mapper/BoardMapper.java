package com.example.FourCylinder.Mapper;


import com.example.FourCylinder.Entity.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int insertBoard(Board board);
    int deleteBoard(int boardId);

}
