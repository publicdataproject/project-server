package com.data.dataproject.service;

import com.data.dataproject.dto.DefaultRes;
import com.data.dataproject.dto.main.*;
import com.data.dataproject.repository.BannerRepository;
import com.data.dataproject.repository.FarmerRepository;
import com.data.dataproject.repository.SeasonRepository;
import com.data.dataproject.utils.crawling.JsoupParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {

    private final BannerRepository bannerRepository;
    private final SeasonRepository seasonRepository;

    private final JsoupParser jsoupParser;

    public DefaultRes<MainDto> getMainInfo() {
        MainDto mainDto = new MainDto();

        mainDto.setBannerDtos(bannerRepository.findAll());
        mainDto.setNewsDtos(jsoupParser.news());
        mainDto.setSeasonDtos(seasonRepository.findAll());

        return DefaultRes.res(200, "main 조회 성공", mainDto);
    }

}
