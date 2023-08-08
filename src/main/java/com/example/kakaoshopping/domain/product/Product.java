package com.example.kakaoshopping.domain.product;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "product_tb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", length = 100, nullable = false)
    private String productName;

    @Column(length = 1000, columnDefinition = "DEFAULT NULL")
    private String description;

    @Column(length = 500, columnDefinition = "DEFAULT NULL")
    private String image;

    @Column(length = 11, columnDefinition = "DEFAULT NULL")
    private int price;


}
