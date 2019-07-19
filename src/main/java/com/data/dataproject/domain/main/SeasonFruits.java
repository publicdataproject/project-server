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
@Table(name = "season_fruits", schema = "data_schema")
@ApiModel
public class SeasonFruits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(notes = "제철과일 id값")
    private Long id;

    @Column(name = "fruitsImage")
    @ApiModelProperty(notes = "제철과일 이미지")
    private String fruitsImage;

    @Column(name = "fruitsName")
    @ApiModelProperty(notes = "제철과일 이름")
    private String fruitsName;

}
