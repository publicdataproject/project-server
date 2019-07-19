package com.data.dataproject.domain.market;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product", schema = "data_schema")
@ApiModel
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    @ApiModelProperty(notes = "상품 id값")
    private Long productId;

    @Column(name = "marketId")
    @ApiModelProperty(notes = "로컬 매장 id값")
    private Long marketId;

    @Column(name = "category")
    @ApiModelProperty(notes = "상품 카테고리")
    private String category;

    @Column(name = "name")
    @ApiModelProperty(notes = "상품 이름")
    private String name;

    @Column(name = "price")
    @ApiModelProperty(notes = "상품 가격")
    private Long price;

    @Column(name = "image")
    @ApiModelProperty(notes = "상품 이미지")
    private String image;
}
