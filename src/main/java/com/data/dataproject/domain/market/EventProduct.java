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
@Table(name = "event_product", schema = "data_schema")
@ApiModel
public class EventProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventProductId")
    @ApiModelProperty(notes = "행사상품 id값")
    private Long eventProductId;

    @Column(name = "marketId")
    @ApiModelProperty(notes = "로컬 매장 id값")
    private Long marketId;

    @Column(name = "name")
    @ApiModelProperty(notes = "행사상품 이름")
    private String name;

    @Column(name = "price")
    @ApiModelProperty(notes = "행사상품 가격")
    private Long price;

    @Column(name = "image")
    @ApiModelProperty(notes = "행사상품 이미지")
    private String image;
}
