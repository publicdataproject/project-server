package com.data.dataproject.repository;

import com.data.dataproject.domain.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByMarketIdAndUserId(Long marketId, Long userId);
    List<Review> findByMarketId(Long marketId);
}
