package com.example.demo.domain.board.controller;

import com.example.demo.domain.board.data.dto.request.BoardWriteRequest;
import com.example.demo.domain.board.data.dto.response.BoardWriteResponse;
import com.example.demo.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/board")
public class BoardController {

    private final BoardService boardService;



    // 게시물 작성
    @PostMapping("/write")
    public ResponseEntity<BoardWriteResponse> writeBoard(@RequestBody BoardWriteRequest boardCreateRequest) {
        return new ResponseEntity<>(boardService.boardCreate(boardCreateRequest), HttpStatus.CREATED);
    }

    // 게시물 모두 가져오기
    @GetMapping
    public ResponseEntity<List<BoardGetResponse>> getBoards() {
        return new ResponseEntity<>(boardService.boardGets(), HttpStatus.OK);
    }

    // 게시물 상세 보기
    @GetMapping("/{id}")
    public ResponseEntity<BoardInfoResponse> getBoard(@PathVariable("id") Long id) {
        return new ResponseEntity<>(boardService.boardGet(id),HttpStatus.OK);
    }

    //게시물 수정
    @PutMapping("/{id}")
    public ResponseEntity<BoardUpdateResponse> updateBoard(@PathVariable("id") Long id ,@RequestBody BoardUpdateRequest boardUpdateRequest) {
        boardService.boardUpdate(boardUpdateRequest, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
