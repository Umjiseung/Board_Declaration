package com.example.demo.domain.trafficlight.data.dto.request;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GreenRequest {

    private final String state;
    private final String content;

}
