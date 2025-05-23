package com.example.FourCylinder.Controller;


import com.example.FourCylinder.Dto.request.ReqBoardDto;
import com.example.FourCylinder.Dto.request.ReqUpdateBoardDto;
import com.example.FourCylinder.Entity.Board;
import com.example.FourCylinder.Entity.User;
import com.example.FourCylinder.Service.BoardService;
import com.example.FourCylinder.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "게시글 수정", description = "게시글 수정")
    @PutMapping("/update")
    public ResponseEntity<?> updateBoard(@RequestBody ReqUpdateBoardDto reqUpdateBoardDto) {
        System.out.println(reqUpdateBoardDto);

        boolean result = boardService.updateBoard(reqUpdateBoardDto);
                return result ? ResponseEntity.ok().body("수정완료")
                : ResponseEntity.badRequest().body("수정실패");
    }

    @Operation(summary = "게시글 삭제", description = "게시글 삭제")
    @DeleteMapping("/boards/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable int boardId) {
        return boardService.deleteBoard(boardId)
            ? ResponseEntity.ok().body("삭제완료")
                : ResponseEntity.badRequest().body("삭제실패");
    }

    @Operation(summary = "게시글 조회", description = "게시글 조회")
    @GetMapping("/board/{boardId}")
    public ResponseEntity<?> selectBoard(@PathVariable int boardId) {
        return ResponseEntity.ok().body(boardService.selectBoard(boardId));
    }

}
