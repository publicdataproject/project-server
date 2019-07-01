package com.data.dataproject.service;


import com.data.dataproject.model.DefaultRes;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(value = "MainController")
public class MainService {

    private final MainService mainService;

    private static final DefaultRes FAIL_DEFAULT_RES = new DefaultRes(500, "서버 내부 에러");

}
