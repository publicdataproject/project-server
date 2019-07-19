package com.data.dataproject.dto.map;


import com.data.dataproject.domain.market.LocalFood;
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
public class MapDto {
    @ApiModelProperty(notes = "로컬푸드 직매장 정보")
    private List<LocalFood> localFoodList;
}
