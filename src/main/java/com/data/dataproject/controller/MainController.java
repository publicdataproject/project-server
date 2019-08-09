package com.data.dataproject.controller;


import com.data.dataproject.dto.DefaultRes;
import com.data.dataproject.dto.main.MainDto;
import com.data.dataproject.service.MainService;
import com.data.dataproject.utils.crawling.JsoupParser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "MainController")
public class MainController {

    private final MainService mainService;

    @ApiOperation(value = "main 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "main 조회 성공"),
            @ApiResponse(code = 500, message = "서버 내부 에러")
    })
    @GetMapping("/main")
    public ResponseEntity<DefaultRes<MainDto>> getMain() {
        return new ResponseEntity<>(mainService.getMainInfo(), HttpStatus.OK);
    }

}
