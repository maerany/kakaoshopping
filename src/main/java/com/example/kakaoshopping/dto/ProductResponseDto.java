package com.example.kakaoshopping.dto;

import com.example.kakaoshopping.domain.product.Product;
import lombok.Getter;

@Getter
public class ProductResponseDto {

//- productId : 상품 번호
//-	productName : 상품 이름
//-	description  : 상품 설명
//-	image : 상품 이미지 경로
//-	price : 상품 가격
    private int id;
    private String productName;
    private String description;
    private String image;
    private int price;

    public ProductResponseDto(Product entity) {
        this.id = entity.getId();
        this.productName = entity.getProductName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
        this.price = entity.getPrice();
    }
}
