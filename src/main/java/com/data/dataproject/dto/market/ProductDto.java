package com.data.dataproject.dto.market;

import com.data.dataproject.domain.market.Product;
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
public class ProductDto {
    @ApiModelProperty(notes = "상품 정보")
    private List<Product> products;
}
