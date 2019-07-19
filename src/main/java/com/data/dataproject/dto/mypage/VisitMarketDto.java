package com.data.dataproject.dto.mypage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class VisitMarketDto {
    @ApiModelProperty(notes = "로컬 매장 이름")
    private String MarketName;

    @ApiModelProperty(notes = "방문 날짜")
    private String date;

    @ApiModelProperty(notes = "상세 정보")
    private VisitMarketDetailDto visitMarketDetailDtos;
}
