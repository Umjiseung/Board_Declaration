package com.example.demo.domain.trafficlight.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "table_traffic")
public class Traffic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "traffic_state")
    private String state;

    @Column(name = "traffic_content")
    private String content;


}
