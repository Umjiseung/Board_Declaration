package com.example.demo.domain.trafficlight.Service;


import com.example.demo.domain.trafficlight.data.dto.request.GreenRequest;
import com.example.demo.domain.trafficlight.data.dto.request.RedRequest;
import com.example.demo.domain.trafficlight.data.dto.response.GreenResponse;
import com.example.demo.domain.trafficlight.data.dto.response.RedResponse;
import com.example.demo.domain.trafficlight.data.dto.response.TrafficAllResponse;
import com.example.demo.domain.trafficlight.data.entity.Traffic;
import com.example.demo.domain.trafficlight.repository.TrafficRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrafficService {

    private final TrafficRepository trafficRepository;

    @Transactional
    public RedResponse redLight(RedRequest redRequest) {

        Traffic traffic = Traffic.builder()
                .state(redRequest.getState())
                .content(redRequest.getContent())
                .build();

        trafficRepository.save(traffic);

        return new RedResponse(
                traffic.getId(),
                traffic.getState(),
                traffic.getContent()
        );

    }

    @Transactional
    public GreenResponse greenLight(GreenRequest greenRequest) {

        Traffic traffic = Traffic.builder()
                .state(greenRequest.getState())
                .content(greenRequest.getContent())
                .build();

        trafficRepository.save(traffic);

        return new GreenResponse(
                traffic.getId(),
                traffic.getState(),
                traffic.getContent()
        );

    }

    @Transactional(readOnly = true)
    public List<TrafficAllResponse> trafficAll() {
        List<Traffic> traffics = trafficRepository.findAll();
        List<TrafficAllResponse> allResponses = new ArrayList<>();

        for (Traffic traffic : traffics) {
            allResponses.add(new TrafficAllResponse(traffic.getId(), traffic.getState(), traffic.getContent()));
        }
        return allResponses;
    }



}
