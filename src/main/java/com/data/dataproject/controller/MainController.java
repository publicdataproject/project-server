package com.data.dataproject.controller;


import com.data.dataproject.model.DefaultRes;
import com.data.dataproject.service.MainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(value = "MainController")
public class MainController {

    private final MainService mainService;

    private static final DefaultRes FAIL_DEFAULT_RES = new DefaultRes(500, "서버 내부 에러");

    @ApiOperation(value = "main 조회", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "main 조회 성공"),
            @ApiResponse(code = 500, message = "서버 내부 에러")
    })
    @GetMapping("/api/main")
    public ResponseEntity getMain() {
        try {
            return new ResponseEntity<>(mainService.getMainInfo(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
