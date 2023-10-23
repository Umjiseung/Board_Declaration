package com.example.demo.domain.trafficlight.repository;


import com.example.demo.domain.trafficlight.data.entity.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficRepository extends JpaRepository<Traffic,Long> {
}
