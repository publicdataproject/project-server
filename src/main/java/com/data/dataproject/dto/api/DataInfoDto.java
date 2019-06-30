package com.data.dataproject.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "Grid_20151029000000000273_1")
public class DataInfoDto {

    private List<DataInfo> row;

    @XmlElement(name = "row")
    public List<DataInfo> getDataInfo() {
        return row;
    }

    public void setDataInfo(List<DataInfo> row) {
        this.row = row;
    }

}
