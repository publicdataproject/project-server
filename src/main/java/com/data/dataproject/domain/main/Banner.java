package com.data.dataproject.domain.main;

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
@Table(name = "banner", schema = "data_schema")
public class Banner {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "bannerImage")
    private String bannerImage;

}
