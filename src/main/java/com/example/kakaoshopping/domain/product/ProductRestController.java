package com.example.kakaoshopping.domain.product;

 
import com.example.kakaoshopping.domain.option.Option;
import com.example.kakaoshopping.domain.option.OptionJPARepository;
import com.example.kakaoshopping.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductService productService;

    // (기능4) 전체 상품 목록 조회
    // TODO : @GetMapping("/products")
    @GetMapping("/products")
    public List<ProductResponseDto> listProduct(Model model){
        // RestController....니까 이렇게 ?@_@
         List<Product> products = productService.findProducts();
         List<ProductResponseDto> result = products.stream()
                 .map(o -> new ProductResponseDto(o))
                 .collect(toList());

         return result;
    }


    // (기능5) 개별 상품 상세 조회
    // TODO : @GetMapping("/products/{id}")
    @GetMapping("/products/{id}")
    public List<Option> selectDetailProduct(@PathVariable int productId){
        return productService.findByProductId(productId);
    }
}