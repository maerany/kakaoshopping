package com.example.kakaoshopping.domain.product;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "option_tb")
@Table(indexes = @Index(name = "option_product_id_idx", columnList = "product_id"))
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
        foreign key 제약조건 지정
     */
    @ManyToOne
    @JoinColumn(name = "product_id", columnDefinition = "DEFAULT NULL")
    private Product productId;

    @Column(name = "option_name", length = 100, nullable = false)
    private String optionName;

    @Column(nullable = false)
    private int price;

}
