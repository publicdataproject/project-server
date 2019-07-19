package com.data.dataproject.dto.market;

import com.data.dataproject.domain.market.EventProduct;
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
public class MarketDto {
    @ApiModelProperty(notes = "매장 이미지")
    private String marketImage;

    @ApiModelProperty(notes = "매장 이름")
    private String marketName;

    @ApiModelProperty(notes = "매장 주소")
    private String marketAddress;

    @ApiModelProperty(notes = "리뷰 별점")
    private Float review;

    @ApiModelProperty(notes = "행사상품 정보")
    private List<EventProduct> eventProducts;
}
