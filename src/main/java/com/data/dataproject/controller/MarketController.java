package com.data.dataproject.controller;

import com.data.dataproject.dto.DefaultRes;
import com.data.dataproject.dto.market.MarketDto;
import com.data.dataproject.dto.market.ProductDto;
import com.data.dataproject.dto.mypage.MypageDto;
import com.data.dataproject.service.MarketService;
import com.data.dataproject.service.MypageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(value = "MarketController")
public class MarketController {

    private final MarketService marketService;

    @ApiOperation(value = "market 정보 조회", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "market 조회 성공"),
            @ApiResponse(code = 500, message = "서버 내부 에러")
    })
    @GetMapping("/api/market/{marketId}")
    public ResponseEntity<DefaultRes<MarketDto>> getMarket(@PathVariable Long marketId) {
        return new ResponseEntity<>(marketService.getMarketInfo(marketId), HttpStatus.OK);

    }


    @ApiOperation(value = "product 정보 조회", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "product 조회 성공"),
            @ApiResponse(code = 500, message = "서버 내부 에러")
    })
    @GetMapping("/api/market/{marketId}/{category}")
    public ResponseEntity<DefaultRes<ProductDto>> getProduct(@PathVariable Long marketId, @PathVariable String category) {
        return new ResponseEntity<>(marketService.getProductInfo(marketId, category), HttpStatus.OK);

    }

}
