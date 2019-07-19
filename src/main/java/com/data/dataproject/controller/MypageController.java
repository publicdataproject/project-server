package com.data.dataproject.controller;

import com.data.dataproject.dto.DefaultRes;
import com.data.dataproject.dto.main.MainDto;
import com.data.dataproject.dto.mypage.MypageDto;
import com.data.dataproject.service.MypageService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "MypageController")
public class MypageController {

    private final MypageService mypageService;

    @ApiOperation(value = "mypage 조회", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "mypage 조회 성공"),
            @ApiResponse(code = 500, message = "서버 내부 에러")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "유저 id값", required = true, dataType = "long"),
    })
    @GetMapping("/mypage/{userId}")
    public ResponseEntity<DefaultRes<MypageDto>> getMapage(@PathVariable Long userId) {
        return new ResponseEntity<>(mypageService.getMapageInfo(userId), HttpStatus.OK);
    }
}
