package com.data.dataproject.controller;

import com.data.dataproject.dto.DefaultRes;
import com.data.dataproject.dto.map.MapDto;
import com.data.dataproject.service.MapInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(value = "DataController")
public class MapController {

    private final MapInfoService mapInfoService;

    @GetMapping("/getData")
    public ResponseEntity<DefaultRes> getLocalData() {
        mapInfoService.getDataInfo();
        return new ResponseEntity<>(DefaultRes.res(200, "api 호출해서 데이터 저장"), HttpStatus.OK);
    }


    @ApiOperation(value = "지역별 로컬직매장 조회", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 500, message = "서버 내부 에러")
    })
    @GetMapping("/api/map/resion/{resion}")
    public ResponseEntity<DefaultRes<MapDto>> getResionData(@PathVariable String resion) {
        return new ResponseEntity<>(mapInfoService.getLocalResionInfo(resion), HttpStatus.OK);
    }


    @ApiOperation(value = "현재 위치 주위의 로컬직매장 조회", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 500, message = "서버 내부 에러")
    })
    @GetMapping("/api/map")
    public ResponseEntity<DefaultRes<MapDto>> getMapData(
            @RequestParam(value = "latitude") final Float latitude,
            @RequestParam(value = "longitude") final Float longitude,
            @RequestParam(value = "radius") final Float radius) {

        return new ResponseEntity<>(mapInfoService.getLocalMapInfo(latitude, longitude, radius), HttpStatus.OK);
    }

}
