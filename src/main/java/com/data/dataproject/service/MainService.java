package com.data.dataproject.service;


import com.data.dataproject.domain.Banner;
import com.data.dataproject.domain.FarmerWord;
import com.data.dataproject.domain.LocalFood;
import com.data.dataproject.domain.SeasonFruits;
import com.data.dataproject.dto.main.*;
import com.data.dataproject.repository.BannerRepository;
import com.data.dataproject.repository.FarmerRepository;
import com.data.dataproject.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {

    private final BannerRepository bannerRepository;
    private final FarmerRepository farmerRepository;
    private final SeasonRepository seasonRepository;

    private ProjectionFactory projectionFactory;


    public MainDto getMainInfo() {
        MainDto mainDto = new MainDto();

//        List<Banner> bannerDtos = bannerRepository.findAll();
//        List<BannerOnly> bannerOnlies = bannerDtos.stream().map(banner -> projectionFactory.createProjection(BannerOnly.class, banner)).collect(Collectors.toList());
//        mainDto.setBannerDtos(bannerOnlies);

        mainDto.setBannerDtos(bannerRepository.findAll());
        mainDto.setFarmerDtos(farmerRepository.findAll());
        mainDto.setSeasonDtos(seasonRepository.findAll());
        return mainDto;

    }



}
