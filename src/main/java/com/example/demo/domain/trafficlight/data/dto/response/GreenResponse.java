package com.example.demo.domain.trafficlight.data.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GreenResponse {

    private final String state;
    private final String content;

}
