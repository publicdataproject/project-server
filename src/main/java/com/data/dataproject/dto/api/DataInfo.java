package com.data.dataproject.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Data
@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataInfo {

    @XmlAttribute(name = "ROW_NUM")
    private String marketNumber;
//
//    @JsonProperty("CTPRVN")
//    private String marketSido;
//
//    @JsonProperty("STR_NM")
//    private String marketName;
//
//    @JsonProperty("ADRES")
//    private String marketAdres;
//
//    @JsonProperty("TLPHON_NO")
//    private String marketTel;
//
//    @JsonProperty("LA")
//    private String marketLa;
//
//    @JsonProperty("LO")
//    private String marketLo;
//
//    @JsonProperty("row")
//    private String row;


}

