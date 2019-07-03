package com.data.dataproject.dto.mypage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitMarketDto {
    private String MarketName;
    private String date;
    private VisitMarketDetailDto visitMarketDetailDtos;
}
