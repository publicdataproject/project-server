package com.data.dataproject.repository;

import com.data.dataproject.domain.market.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByMarketIdAndCategory(Long marketId, String category);
}
