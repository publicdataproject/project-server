package com.data.dataproject.dto.main;

import com.data.dataproject.domain.main.Banner;
import com.data.dataproject.domain.main.FarmerWord;
import com.data.dataproject.domain.main.SeasonFruits;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class MainDto {
    @ApiModelProperty(notes = "배너 정보")
    private List<Banner> bannerDtos;

    @ApiModelProperty(notes = "농민뉴스 정보")
    private List<NewsDto> newsDtos;

    @ApiModelProperty(notes = "제철과일 정보")
    private List<SeasonFruits> seasonDtos;
}
