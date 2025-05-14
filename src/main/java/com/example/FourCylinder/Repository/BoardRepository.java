package com.example.FourCylinder.Repository;


import com.example.FourCylinder.Entity.Board;
import com.example.FourCylinder.Mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository {

    @Autowired
    private BoardMapper boardMapper;

    public Board saveBoard(Board board) {
        boardMapper.insertBoard(board);
        return board;
    }


    public int deleteBoard(int boardId) {
       return boardMapper.deleteBoard(boardId);

    }
}
