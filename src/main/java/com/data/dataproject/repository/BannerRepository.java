package com.data.dataproject.repository;

import com.data.dataproject.domain.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, String> {
    @Query(value="select bannerImage from banner", nativeQuery=true)
    List<String> findBannerImage();
}
