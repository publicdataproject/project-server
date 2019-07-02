package com.data.dataproject.service;

import com.data.dataproject.domain.LocalFood;
import com.data.dataproject.dto.map.MapDto;
import com.data.dataproject.repository.LocalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class MapInfoService {

    private final LocalRepository localRepository;

    private static final String BASE_URL="http://211.237.50.150:7080/openapi/7c2f9f255ea5100b1c800f6694ca920cc38775dd9956fd9186a0fcd1eca7bffb/json/Grid_20151029000000000273_1/1/5";
    private final RestTemplate restTemplate;
    private JSONObject object;

    public JSONObject getDataInfo() {

        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUri();

        String dataInfoDto = restTemplate.getForObject(uri, String.class);

        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(dataInfoDto);

            JSONObject grid = (JSONObject) jsonObject.get("Grid_20151029000000000273_1");
            JSONArray row = (JSONArray) grid.get("row");

            for(int i = 0; i < row.size(); i++){
                object = (JSONObject) row.get(i);

                LocalFood localFood = new LocalFood();
                localFood.setId(Long.parseLong(object.get("ROW_NUM").toString()));
                localFood.setCity(object.get("CTPRVN").toString());
                localFood.setName(object.get("STR_NM").toString());
                localFood.setAddress(object.get("RDNMADR").toString());
                localFood.setPhone(object.get("TLPHON_NO").toString());
                localFood.setLatitude(Float.parseFloat(object.get("LA").toString()));
                localFood.setLongitude(Float.parseFloat(object.get("LO").toString()));
                localRepository.save(localFood);
            }

            return object;

        } catch (Exception e) {
            log.error(e.getMessage());
            return object; //고치기
        }
    }

    public Optional<LocalFood> getLocalIdInfo(Long id) {
        Optional<LocalFood> localFood = localRepository.findById(id);
        return localFood;
    }


    public MapDto getLocalResionInfo(String resion) {
        MapDto mapDto = new MapDto();
        mapDto.setLocalFoodList(localRepository.findAllByCity(resion));
        return mapDto;
    }

    public MapDto getLocalMapInfo(Float latitude, Float longitude, Float radius) {
        MapDto mapDto = new MapDto();
        mapDto.setLocalFoodList(localRepository.findAllByAddress(latitude, longitude, radius));
        return mapDto;
    }


}

