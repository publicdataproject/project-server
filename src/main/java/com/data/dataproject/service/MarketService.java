package com.data.dataproject.service;

import com.data.dataproject.domain.login.User;
import com.data.dataproject.domain.market.EventProduct;
import com.data.dataproject.domain.market.LocalFood;
import com.data.dataproject.domain.market.Product;
import com.data.dataproject.dto.market.MarketDto;
import com.data.dataproject.dto.market.ProductDto;
import com.data.dataproject.dto.mypage.MypageDto;
import com.data.dataproject.repository.EventProductRepository;
import com.data.dataproject.repository.LocalRepository;
import com.data.dataproject.repository.ProductRepository;
import com.data.dataproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarketService {

    private final LocalRepository localRepository;
    private final EventProductRepository eventProductRepository;
    private final ProductRepository productRepository;

    public MarketDto getMarketInfo(Long marketId){
        Optional<LocalFood> localFood = localRepository.findById(marketId);
        List<EventProduct> eventProduct = eventProductRepository.findByMarketId(marketId);

        MarketDto marketDto = new MarketDto();
        marketDto.setMarketImage(localFood.get().getImage());
        marketDto.setMarketName(localFood.get().getName());
        marketDto.setMarketAddress(localFood.get().getAddress());
        marketDto.setReview(0L);
        marketDto.setEventProducts(eventProduct);

        return marketDto;

    }

    public ProductDto getProductInfo(Long marketId, String category){
        List<Product> products = productRepository.findByMarketIdAndCategory(marketId, category);

        ProductDto productDto = new ProductDto();
        productDto.setProducts(products);

        return productDto;
    }
}
