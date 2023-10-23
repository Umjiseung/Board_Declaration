package com.example.demo.domain.board.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "table_board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "board_id")
    private Long id;

    @Column(name = "board_location")
    private String location;

    @Column(name = "board_content")
    private String content;


}
