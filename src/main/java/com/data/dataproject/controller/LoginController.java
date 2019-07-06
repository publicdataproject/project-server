package com.data.dataproject.controller;

import com.data.dataproject.dto.DefaultRes;
import com.data.dataproject.dto.login.LoginDto;
import com.data.dataproject.dto.login.TokenDto;
import com.data.dataproject.service.AuthService;
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
//@ControllerAdvice
@RestController
@RequiredArgsConstructor
@Api(value = "LoginController")
public class LoginController {

    private final AuthService authService;

    @ApiOperation(value = "카카오 로그인", notes = "성공시 jwt 토큰을 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "로그인 성공"),
            @ApiResponse(code = 500, message = "서버 내부 에러")
    })
    @PostMapping(value = "/api/login")
    public ResponseEntity<DefaultRes<LoginDto>> login(@RequestBody TokenDto tokenDto) {
        return new ResponseEntity<>(authService.login(tokenDto), HttpStatus.OK);
    }

}
