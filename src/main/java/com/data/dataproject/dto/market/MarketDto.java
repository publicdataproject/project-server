package com.data.dataproject.dto.market;

import com.data.dataproject.domain.market.EventProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketDto {
    private String marketImage;
    private String marketName;
    private String marketAddress;
    private Long review;
    private List<EventProduct> eventProducts;
}
