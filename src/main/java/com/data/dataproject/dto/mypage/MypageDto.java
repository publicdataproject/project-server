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
public class MypageDto {
    @ApiModelProperty(notes = "유저 이름")
    private String name;

    @ApiModelProperty(notes = "포인트")
    private Long point;

    @ApiModelProperty(notes = "방문매장 정보")
    private List<VisitMarketDto> visitMarketDtos;
}
