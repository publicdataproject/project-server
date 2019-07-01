package com.data.dataproject.service;


import com.data.dataproject.domain.Banner;
import com.data.dataproject.domain.FarmerWord;
import com.data.dataproject.domain.LocalFood;
import com.data.dataproject.domain.SeasonFruits;
import com.data.dataproject.model.DefaultRes;
import com.data.dataproject.repository.BannerRepository;
import com.data.dataproject.repository.FarmerRepository;
import com.data.dataproject.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {

    private final BannerRepository bannerRepository;
    private final FarmerRepository farmerRepository;
    private final SeasonRepository seasonRepository;

    public DefaultRes<List> getMainInfo() {

        List<String> bannerList = bannerRepository.findBannerImage();
//        List<FarmerWord> farmerWordList = farmerRepository.findAll();
        List<String> seasonFruitsList = seasonRepository.findFruits();

        List<List> mainList = new ArrayList<List>();
        mainList.add(bannerList);
//        mainList.add(farmerWordList);
        mainList.add(seasonFruitsList);


        return DefaultRes.res(200, "main 조회 성공", mainList);
    }

}
