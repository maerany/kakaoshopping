package com.example.kakaoshopping.domain.cart;

import com.example.kakaoshopping.domain.product.Option;
import com.example.kakaoshopping.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "cart_tb")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "option_id"}),
       indexes = {
           @Index(name = "cart_user_id_idx", columnList = "user_id"),
           @Index(name = "cart_option_id_idx", columnList = "option_id")
       })
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //
    @Column(name ="user_id", nullable = false)
    private Long userId;

    @Column(name ="option_id", nullable = false)
    private Long optionId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;


}
