package com.example.demo.domain.board.service.impl;

import com.example.demo.domain.board.data.dto.request.BoardUpdateRequest;
import com.example.demo.domain.board.data.dto.request.BoardWriteRequest;
import com.example.demo.domain.board.data.dto.response.BoardGetResponse;
import com.example.demo.domain.board.data.dto.response.BoardInfoResponse;
import com.example.demo.domain.board.data.dto.response.BoardWriteResponse;
import com.example.demo.domain.board.data.entity.Board;
import com.example.demo.domain.board.repository.BoardRepository;
import com.example.demo.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public BoardWriteResponse boardWrite(BoardWriteRequest writeRequest) {
        if (Stream.of(
                writeRequest.getLocation(),
                writeRequest.getContent())
                .anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("필수사항이 작성되지 않았습니다.");}

        Board content = Board.builder()
                .id(writeRequest.getId())
                .location(writeRequest.getLocation())
                .content(writeRequest.getContent())
                .build();
        content = boardRepository.save(content);
        return new BoardWriteResponse(content.getId(),content.getLocation(),content.getContent());
    }

    @Override
    @Transactional(readOnly = true)
    public List<BoardGetResponse> boardGets() {
        List<Board> boards = boardRepository.findAll();
        List<BoardGetResponse> boardGetResponses = new ArrayList<>();

        for (Board board : boards) {
            boardGetResponses.add(new BoardGetResponse(board.getId(), board.getLocation(), board.getContent()));
        }
        return boardGetResponses;
    }

    @Override
    @Transactional(readOnly = true)
    public BoardInfoResponse boardGet(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return new BoardInfoResponse(board.getId(),board.getLocation(),board.getContent());
    }

    @Override
    @Transactional
    public void boardUpdate(BoardUpdateRequest boardUpdateRequest, Long id) {
        Board board = boardRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        board.setContent(boardUpdateRequest.getContent());
        board.setLocation(boardUpdateRequest.getLocation());
        boardRepository.save(board);
    }


}
