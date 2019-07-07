package com.data.dataproject.domain.main;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "season_fruits", schema = "data_schema")
public class SeasonFruits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fruitsImage")
    private String fruitsImage;

    @Column(name = "fruitsName")
    private String fruitsName;

}
