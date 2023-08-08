package com.example.kakaoshopping.domain.product;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "option_tb")
@Table(indexes = @Index(name = "option_product_id_idx", columnList = "product_id"))
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(length = 100, nullable = false)
    private String optionName;
    private int price;

    @Builder
    public Option(int id, Product product, String optionName, int price) {
        this.id = id;
        this.product = product;
        this.optionName = optionName;
        this.price = price;
    }

}
