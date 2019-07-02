package com.data.dataproject.repository;

import com.data.dataproject.domain.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BannerRepository extends JpaRepository<Banner, String> {


//    @Query(value="select bannerImage from banner", nativeQuery=true)
//    List<BannerOnly> findBannerImage();

//
//    public interface BannerOnly {
//        String getBannerImage();
//    }
}
