package com.data.dataproject.dto.review;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ReviewDto {

    @ApiModelProperty(notes = "로컬 매장 id값")
    private Long marketId;

    @ApiModelProperty(notes = "유저 id값")
    private Long userId;

    @ApiModelProperty(notes = "리뷰 내용")
    private String content;

    @ApiModelProperty(notes = "리뷰 별점")
    private Float star;

}
