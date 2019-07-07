package com.data.dataproject.service;

import com.data.dataproject.domain.market.LocalFood;
import com.data.dataproject.dto.DefaultRes;
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


@Service
@RequiredArgsConstructor
@Slf4j
public class MapInfoService {

    private final LocalRepository localRepository;

    private static final String BASE_URL = "http://211.237.50.150:7080/openapi/7c2f9f255ea5100b1c800f6694ca920cc38775dd9956fd9186a0fcd1eca7bffb/json/Grid_20151029000000000273_1/1/92";
    private final RestTemplate restTemplate;
    private JSONObject object;

    public void getDataInfo() {

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

            for (int i = 0; i < row.size(); i++) {
                object = (JSONObject) row.get(i);

                if (!(object.get("LA").toString().isEmpty()) && !(object.get("LO").toString().isEmpty())) {
                    LocalFood localFood = new LocalFood();
                    localFood.setId(Long.parseLong(object.get("ROW_NUM").toString()));
                    localFood.setCity(object.get("CTPRVN").toString());
                    localFood.setName(object.get("STR_NM").toString());
                    localFood.setAddress(object.get("ADRES").toString());
                    localFood.setPhone(object.get("TLPHON_NO").toString());
                    localFood.setLatitude(Float.parseFloat(object.get("LA").toString()));
                    localFood.setLongitude(Float.parseFloat(object.get("LO").toString()));
                    localFood.setReview(0f);

                    localRepository.save(localFood);
                }

            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public DefaultRes<MapDto> getLocalResionInfo(String resion) {
        MapDto mapDto = new MapDto();
        mapDto.setLocalFoodList(localRepository.findAllByCity(resion));

        return DefaultRes.res(200, "지역별 로컬직매장 조회", mapDto);
    }


    public DefaultRes<MapDto> getLocalMapInfo(Float latitude, Float longitude, Float radius) {
        MapDto mapDto = new MapDto();
        mapDto.setLocalFoodList(localRepository.findAllByAddress(latitude, longitude, radius));

        return DefaultRes.res(200, "현재 위치 주위의 로컬직매장 조회", mapDto);
    }


}

