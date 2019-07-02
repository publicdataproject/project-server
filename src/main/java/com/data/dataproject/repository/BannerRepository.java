package com.data.dataproject.repository;

import com.data.dataproject.domain.Banner;
import com.data.dataproject.dto.main.BannerDto;
import com.data.dataproject.dto.main.BannerOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, String> {


//    @Query(value="select bannerImage from banner", nativeQuery=true)
//    List<BannerOnly> findBannerImage();

//
//    public interface BannerOnly {
//        String getBannerImage();
//    }
}
