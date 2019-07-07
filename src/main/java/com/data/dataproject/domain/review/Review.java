package com.data.dataproject.domain.review;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review", schema = "data_schema")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId")
    private Long reviewId;

    @Column(name = "marketId")
    private Long marketId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "content")
    private String content;

    @Column(name = "star")
    private Float star;
}
