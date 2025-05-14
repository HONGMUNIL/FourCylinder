package com.example.FourCylinder.Service;


import com.example.FourCylinder.Dto.request.ReqBoardDto;
import com.example.FourCylinder.Entity.Board;
import com.example.FourCylinder.Entity.User;
import com.example.FourCylinder.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    //생성
    public Board createBoard(ReqBoardDto reqBoardDto) {
        Board board = Board.builder()
                .title(reqBoardDto.getTitle())
                .content(reqBoardDto.getContent())
                .author(reqBoardDto.getAuthor())
                .build();
        return boardRepository.saveBoard(board);
    }

    //삭제
    public boolean deleteBoard(int boardId) {
        return boardRepository.deleteBoard(boardId) > 0 ? true : false;
    }

}