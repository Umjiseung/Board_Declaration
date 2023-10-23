package com.example.demo.domain.trafficlight.controller;

import com.example.demo.domain.trafficlight.Service.TrafficService;
import com.example.demo.domain.trafficlight.data.dto.request.GreenRequest;
import com.example.demo.domain.trafficlight.data.dto.request.RedRequest;
import com.example.demo.domain.trafficlight.data.dto.response.GreenResponse;
import com.example.demo.domain.trafficlight.data.dto.response.RedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/traffic")
public class TrafficController {

    private final TrafficService trafficService;

    @PostMapping("/red")
    public ResponseEntity<RedResponse> redLight(@RequestBody RedRequest redRequest) {
        trafficService.redLight(redRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/green")
    public ResponseEntity<GreenResponse> greenLight(@RequestBody GreenRequest greenRequest) {
        trafficService.greenLight(greenRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
