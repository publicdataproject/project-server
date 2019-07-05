package com.data.dataproject.dto.main;

import com.data.dataproject.domain.main.Banner;
import com.data.dataproject.domain.main.FarmerWord;
import com.data.dataproject.domain.main.SeasonFruits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainDto {
    private List<Banner> bannerDtos;
    private List<FarmerWord> farmerDtos;
    private List<SeasonFruits> seasonDtos;
}
