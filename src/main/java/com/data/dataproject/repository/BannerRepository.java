package com.data.dataproject.repository;

import com.data.dataproject.domain.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, String> {
    List<Banner> findAll();
}
