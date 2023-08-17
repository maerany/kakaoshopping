package com.example.kakaoshopping.domain.cart;

import com.example.kakaoshopping.domain.option.Option;
import com.example.kakaoshopping.domain.user.User;
import lombok.Getter;
import lombok.Setter;

public class CartRequest {
    // W? Cart 도메인에 대한 요청 data 담는 class?
    // 1. 장바구니 저장 - SaveDTO
    // 2. 장바구니 수정 - UpdateDTO
    // 3. 장바구니 조회


    @Getter @Setter
    public static class SaveDTO{
        // W? optionId로 optionId에 따른 옵션 객체를 가져 와서 사용?
        // client에서 장바구니 선택할 때는 객체배열 형태로 들어오겠지? -> JSON Array

        private int optionId;
        private int quantity;

        public Cart toEntity(Option option, User user){
            Cart cart = Cart.builder()
                    .user(user)
                    .option(option)
                    .quantity(quantity)
                    .price(option.getPrice() * quantity)
                    .build();
            return cart;
        }
    }

    @Getter @Setter
    public static class UpdateDTO{
        private int cartId;
        private int quantity;
    }


}
