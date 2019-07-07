package com.data.dataproject.service;

import com.data.dataproject.domain.review.Review;
import com.data.dataproject.dto.DefaultRes;
import com.data.dataproject.dto.mypage.MypageDto;
import com.data.dataproject.dto.review.ReviewDto;
import com.data.dataproject.dto.review.ReviewListDto;
import com.data.dataproject.repository.LocalRepository;
import com.data.dataproject.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final LocalRepository localRepository;

    public void saveReview(ReviewDto reviewDto) {
        Review saveReview = new Review();
        saveReview.setMarketId(reviewDto.getMarketId());
        saveReview.setUserId(reviewDto.getUserId());
        saveReview.setContent(reviewDto.getContent());
        saveReview.setStar(reviewDto.getStar());

        reviewRepository.save(saveReview);

        Float reviewSum = reviewNum(reviewDto.getMarketId());
        localRepository.updateReview(reviewSum, reviewDto.getMarketId());

    }

    public DefaultRes<ReviewListDto> getReviewInfo(Long marketId) {
        ReviewListDto reviewListDto = new ReviewListDto();
        reviewListDto.setReviews(reviewRepository.findByMarketId(marketId));
        return DefaultRes.res(200, "market별 review 조회 성공", reviewListDto);
    }

    public Float reviewNum(Long marketId) {
        List<Review> reviews = reviewRepository.findByMarketId(marketId);
        Float starSum = 0F;

        for(int i = 0; i < reviews.size(); i++) {
            starSum += reviews.get(i).getStar();
        }
        return starSum;
    }

}
