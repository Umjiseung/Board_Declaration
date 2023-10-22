package com.example.demo.domain.board.service;

import com.example.demo.domain.board.data.dto.request.BoardUpdateRequest;
import com.example.demo.domain.board.data.dto.request.BoardWriteRequest;
import com.example.demo.domain.board.data.dto.response.BoardGetResponse;
import com.example.demo.domain.board.data.dto.response.BoardInfoResponse;
import com.example.demo.domain.board.data.dto.response.BoardWriteResponse;

import java.util.List;

public interface BoardService {

    BoardWriteResponse boardWrite(BoardWriteRequest writeRequest);
    List<BoardGetResponse> boardGets();
    BoardInfoResponse boardGet(Long id);
    void boardUpdate(BoardUpdateRequest boardUpdateRequest, Long id);

}
