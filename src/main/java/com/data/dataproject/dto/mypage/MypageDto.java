package com.data.dataproject.dto.mypage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MypageDto {
    private String name;
    private Integer point;
    private List<VisitMarketDto> visitMarketDtos;
}