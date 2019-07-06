package com.data.dataproject.repository;

import com.data.dataproject.domain.market.EventProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventProductRepository extends JpaRepository<EventProduct, Long> {

    List<EventProduct> findByMarketId(Long marketId);
}
