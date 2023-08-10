package com.example.kakaoshopping.domain.product;

 
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductService productService;

    // (기능4) 전체 상품 목록 조회
    // TODO : @GetMapping("/products")

    // (기능5) 개별 상품 상세 조회
    // TODO : @GetMapping("/products/{id}")
}