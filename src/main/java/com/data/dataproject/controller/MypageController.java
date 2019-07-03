package com.data.dataproject.controller;

import com.data.dataproject.dto.main.MainDto;
import com.data.dataproject.dto.mypage.MypageDto;
import com.data.dataproject.service.MypageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(value = "MypageController")
public class MypageController {

    private final MypageService mypageService;

    @ApiOperation(value = "mypage 조회", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "mypage 조회 성공"),
            @ApiResponse(code = 500, message = "서버 내부 에러")
    })
    @GetMapping("/api/mypage/{id}")
    public ResponseEntity<MypageDto> getMapage(@PathVariable Long id) {
        return ResponseEntity.ok().body(mypageService.getMapageInfo(id));
    }
}
