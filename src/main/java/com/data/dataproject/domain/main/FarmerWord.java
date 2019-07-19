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
@Table(name = "farmer_word", schema = "data_schema")
@ApiModel
public class FarmerWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(notes = "농민한마디 id값")
    private Long id;

    @Column(name = "farmerImage")
    @ApiModelProperty(notes = "농민 이미지")
    private String farmerImage;

    @Column(name = "content")
    @ApiModelProperty(notes = "한마디")
    private String content;

}
