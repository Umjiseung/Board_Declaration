package com.example.demo.domain.board.data.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BoardWriteRequest {

    private final Long id;
    private final String location;
    private final String content;

}
