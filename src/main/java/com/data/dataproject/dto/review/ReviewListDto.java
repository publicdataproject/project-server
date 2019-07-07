package com.data.dataproject.dto.review;

import com.data.dataproject.domain.review.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewListDto {

    private List<Review> reviews;

}
