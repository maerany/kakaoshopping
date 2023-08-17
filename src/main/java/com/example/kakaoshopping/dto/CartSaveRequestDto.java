package com.example.kakaoshopping.dto;

import com.example.kakaoshopping.domain.cart.Cart;
import com.example.kakaoshopping.domain.option.Option;
import com.example.kakaoshopping.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@NoArgsConstructor
public class CartSaveRequestDto {


    private User user;
    private Option option;
    private int quantity;
    private int price;

    @Builder
    public CartSaveRequestDto(User user, Option option, int quantity, int price) {
        this.user = user;
        this.option = option;
        this.quantity = quantity;
        this.price = price;
    }

    public Cart toEntity(){
        return Cart.builder()
                .user(user)
                .option(option)
                .quantity(quantity)
                .price(price)
                .build();
    }



}
