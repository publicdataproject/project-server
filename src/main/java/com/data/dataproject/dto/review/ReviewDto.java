package com.data.dataproject.dto.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private Long marketId;

    private Long userId;

    private String content;

    private Float star;

}
