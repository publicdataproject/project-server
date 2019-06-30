package com.data.dataproject.controller;

import com.data.dataproject.dto.TokenDto;
import com.data.dataproject.model.DefaultRes;
import com.data.dataproject.service.DataInfoService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(value = "DataController")
public class DataController {

    private final DataInfoService dataInfoService;

    private static final DefaultRes FAIL_DEFAULT_RES = new DefaultRes(500, "서버 내부 에러");


    @GetMapping("/getdata")
    public ResponseEntity getLocalData() {
        try {
            return new ResponseEntity<>(dataInfoService.getDataInfo(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getLocalId")
    public ResponseEntity getIdData(@RequestParam(value = "id") final Long id) {
        try {
            return new ResponseEntity<>(dataInfoService.getLocalIdInfo(id), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getLocalResion")
    public ResponseEntity getResionData(@RequestParam(value = "resion") final String resion) {
        try {
            return new ResponseEntity<>(dataInfoService.getLocalResionInfo(resion), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getLocalMap")
    public ResponseEntity getMapData(
            @RequestParam(value = "latitude") final Float latitude,
            @RequestParam(value = "longitude") final Float longitude,
            @RequestParam(value = "radius") final Float radius) {
        try {
            return new ResponseEntity<>(dataInfoService.getLocalMapInfo(latitude, longitude, radius), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
