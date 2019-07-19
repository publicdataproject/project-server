package com.data.dataproject.domain.main;

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
@Table(name = "banner", schema = "data_schema")
@ApiModel
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(notes = "배너 id값")
    private Long id;

    @Column(name = "bannerImage")
    @ApiModelProperty(notes = "배너 이미지")
    private String bannerImage;

}
