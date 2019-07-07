package com.data.dataproject.controller;

import com.data.dataproject.domain.review.Review;
import com.data.dataproject.dto.DefaultRes;
import com.data.dataproject.dto.review.ReviewDto;
import com.data.dataproject.dto.review.ReviewListDto;
import com.data.dataproject.repository.ReviewRepository;
import com.data.dataproject.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(value = "ReviewController")
public class ReviewController {

    private final ReviewService reviewService;

    private final ReviewRepository reviewRepository;


    @ApiOperation(value = "review 작성", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "review 작성"),
            @ApiResponse(code = 500, message = "서버 내부 에러"),
            @ApiResponse(code = 400, message = "이미 리뷰를 작성했음")

    })
    @PostMapping("/api/review/write")
    public ResponseEntity<DefaultRes> postReview(@RequestBody ReviewDto reviewDto) {
        Optional<Review> review = reviewRepository.findByMarketIdAndUserId(reviewDto.getMarketId(), reviewDto.getUserId());
        if (review.isPresent()) {
            return new ResponseEntity<>(DefaultRes.res(400, "이미 리뷰를 작성했음"), HttpStatus.BAD_REQUEST);
        } else {
            reviewService.saveReview(reviewDto);
            return new ResponseEntity<>(DefaultRes.res(200, "리뷰 작성 성공"), HttpStatus.OK);
        }
    }


    @ApiOperation(value = "market별 review 조회", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "market별 review 조회 성공"),
            @ApiResponse(code = 500, message = "서버 내부 에러")
    })
    @GetMapping("/api/review/{marketId}")
    public ResponseEntity<DefaultRes<ReviewListDto>> getReview(@PathVariable Long marketId) {
        return new ResponseEntity<>(reviewService.getReviewInfo(marketId), HttpStatus.OK);
    }

}
