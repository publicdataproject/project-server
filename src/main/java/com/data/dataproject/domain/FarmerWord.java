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
@Table(name = "farmer_word", schema = "data_schema")
public class FarmerWord {
    private String farmerImage;
    private String content;

}
