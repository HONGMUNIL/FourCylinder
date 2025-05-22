package com.example.FourCylinder.Service;


import com.example.FourCylinder.Dto.request.ReqBoardDto;
import com.example.FourCylinder.Dto.request.ReqUpdateBoardDto;
import com.example.FourCylinder.Entity.Board;
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

    public boolean updateBoard(ReqUpdateBoardDto reqUpdateBoardDto) {

        System.out.println("받은 boardId: " + reqUpdateBoardDto.getBoardId());
        Board board = Board.builder()
                .title(reqUpdateBoardDto.getTitle())
                .content(reqUpdateBoardDto.getContent())
                .build();


        int result = boardRepository.updateBoard(board);
        System.out.println("DB에서 수정된 행 수: " + result);
        return result > 0;
    }
    //조회
    public Board selectBoard(int boardId) {
        return boardRepository.findByBoardId(boardId);
    }

    //삭제
    public boolean deleteBoard(int boardId) {
        return boardRepository.deleteBoard(boardId) > 0 ? true : false;
    }

}