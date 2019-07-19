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
@Table(name = "localfood", schema = "data_schema")
@ApiModel
public class LocalFood {

    @Id
    @Column(name = "id")
    @ApiModelProperty(notes = "로컬 매장 id값")
    private Long id;

    @Column(name = "city")
    @ApiModelProperty(notes = "지역")
    private String city;

    @Column(name = "name")
    @ApiModelProperty(notes = "매장 이름")
    private String name;

    @Column(name = "address")
    @ApiModelProperty(notes = "매장 주소")
    private String address;

    @ApiModelProperty(notes = "매장 전화번호")
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(notes = "위도")
    @Column(name = "latitude")
    private Float latitude;

    @ApiModelProperty(notes = "경도")
    @Column(name = "longitude")
    private Float longitude;

    @ApiModelProperty(notes = "매장 이미지")
    @Column(name = "image")
    private String image;

    @ApiModelProperty(notes = "작은 이미지")
    @Column(name = "image_small")
    private String image_small;

    @ApiModelProperty(notes = "리뷰 별점")
    @Column(name = "review")
    private Float review;

}
