package com.example.demo.domain.board.data.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class BoardGetResponse {

    private final Long id;
    private final String location;
    private final String about;


}
