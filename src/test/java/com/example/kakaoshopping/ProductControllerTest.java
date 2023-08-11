package com.example.kakaoshopping;

import com.example.kakaoshopping.domain.product.Product;
import com.example.kakaoshopping.domain.product.ProductRepository;
import com.example.kakaoshopping.dto.ProductResponseDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Column;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {

    @Autowired
    ProductRepository productRepository;

    @After
    public void cleanUp(){
        productRepository.deleteAll();
    }

    @Test
    public void 상품목록_불러오기() throws Exception{
        //given
        String productName = "테스트 상품";
        String description = "테스트 본문";

        productRepository.save(Product.builder()
                .productName(productName)
                .description(description)
                .build());

        //when
        List<Product> productList= productRepository.findAll();
        List<ProductResponseDto> result = productList.stream()
                .map(o -> new ProductResponseDto(o))
                .collect(toList());
        //then
        ProductResponseDto prd = result.get(0);
        assertThat(prd.getProductName()).isEqualTo(productName);
        assertThat(prd.getDescription()).isEqualTo(description);

    }


    @Test
    public void 개별상품_조회하기() throws Exception{

    }

}
