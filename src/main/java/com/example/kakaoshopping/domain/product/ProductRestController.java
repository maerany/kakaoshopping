package com.example.kakaoshopping.domain.product;

 
import com.example.kakaoshopping._core.config.security.CustomUserDetails;
import com.example.kakaoshopping._core.utils.ApiUtils;
import com.example.kakaoshopping.domain.option.Option;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductService productService;

    // (기능4) 전체 상품 목록 조회
    // TODO : @GetMapping("/products")
    @GetMapping("/products")
    public ResponseEntity<?> findAll(@AuthenticationPrincipal CustomUserDetails userDetails){
        ProductResponse.FindAllDTO responseDTO = productService.findAll();
        ApiUtils.ApiResult<?> apiResult = ApiUtils.success(responseDTO);
        return ResponseEntity.ok(apiResult);
    }


    // (기능5) 개별 상품 상세 조회
    // TODO : @GetMapping("/products/{id}")

}