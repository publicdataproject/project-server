package com.data.dataproject.dto.market;

import com.data.dataproject.domain.market.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private List<Product> products;
}
