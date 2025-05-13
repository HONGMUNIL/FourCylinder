package com.example.FourCylinder.Controller;


import com.example.FourCylinder.Dto.request.ReqBoardDto;
import com.example.FourCylinder.Entity.Board;
import com.example.FourCylinder.Entity.User;
import com.example.FourCylinder.Service.BoardService;
import com.example.FourCylinder.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Operation(summary = "게시글 생성", description = "게시글 생성")
    @PostMapping("/create")
    public ResponseEntity<?> createBoard(@RequestBody ReqBoardDto reqBoardDto) {
        return ResponseEntity.ok().body(boardService.createBoard(reqBoardDto));

    }
}
