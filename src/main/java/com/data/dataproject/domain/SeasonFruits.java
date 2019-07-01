package com.data.dataproject.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "season_fruits", schema = "data_schema")
public class SeasonFruits {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "fruitsImage")
    private String fruitsImage;

    @Column(name = "fruitsName")
    private String fruitsName;

}
