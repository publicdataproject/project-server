package com.data.dataproject.service;

import com.data.dataproject.dto.DefaultRes;
import com.data.dataproject.dto.main.*;
import com.data.dataproject.repository.BannerRepository;
import com.data.dataproject.repository.FarmerRepository;
import com.data.dataproject.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {

    private final BannerRepository bannerRepository;
    private final FarmerRepository farmerRepository;
    private final SeasonRepository seasonRepository;

    public DefaultRes<MainDto> getMainInfo() {
        MainDto mainDto = new MainDto();

        mainDto.setBannerDtos(bannerRepository.findAll());
        mainDto.setFarmerDtos(farmerRepository.findAll());
        mainDto.setSeasonDtos(seasonRepository.findAll());

        return DefaultRes.res(200, "main 조회 성공", mainDto);
    }

}
