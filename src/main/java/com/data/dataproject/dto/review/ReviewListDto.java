package com.data.dataproject.dto.review;

import com.data.dataproject.domain.review.Review;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ReviewListDto {

    @ApiModelProperty(notes = "리뷰 정보")
    private List<Review> reviews;

}
