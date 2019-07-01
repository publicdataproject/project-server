package com.data.dataproject.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "season_fruits", schema = "data_schema")
public class SeasonFruits {
    private String fruitsImage;
    private String fruitsName;

}
