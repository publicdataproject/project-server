package com.data.dataproject.dto.main;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class NewsDto {

    @ApiModelProperty(notes = "뉴스 id값")
    private Long id;

    @ApiModelProperty(notes = "뉴스 타이틀")
    private String title;

    @ApiModelProperty(notes = "뉴스 이미지")
    private String image;

    @ApiModelProperty(notes = "뉴스 링크")
    private String rink;

}
