package com.data.dataproject.domain.review;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review", schema = "data_schema")
@ApiModel
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId")
    @ApiModelProperty(notes = "리뷰 id값")
    private Long reviewId;

    @Column(name = "marketId")
    @ApiModelProperty(notes = "로컬 매장 id값")
    private Long marketId;

    @Column(name = "userId")
    @ApiModelProperty(notes = "유저 id값")
    private Long userId;

    @Column(name = "content")
    @ApiModelProperty(notes = "리뷰 내용")
    private String content;

    @Column(name = "star")
    @ApiModelProperty(notes = "리뷰 별점")
    private Float star;
}
