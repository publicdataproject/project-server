package com.data.dataproject.domain.market;

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
@Table(name = "event_product", schema = "data_schema")
public class EventProduct {
    @Id
    @Column(name = "eventProductId")
    private Long eventProductId;

    @Column(name = "marketId")
    private Long marketId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "image")
    private String image;
}
