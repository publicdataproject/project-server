package com.data.dataproject.controller;

import com.data.dataproject.dto.TokenDto;
import com.data.dataproject.model.DefaultRes;
import com.data.dataproject.service.AuthService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Slf4j
@ControllerAdvice
@RestController
@RequiredArgsConstructor
@Api(value = "LoginController")
public class LoginController {

    private static final DefaultRes FAIL_DEFAULT_RES = new DefaultRes(500, "서버 내부 에러");

    private final AuthService authService;
    

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody TokenDto tokenDto) {
        return new ResponseEntity<>(authService.login(tokenDto), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity noLoginException(Exception e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
