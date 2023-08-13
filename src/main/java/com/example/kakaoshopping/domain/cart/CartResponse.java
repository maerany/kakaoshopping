package com.example.kakaoshopping.domain.cart;

import com.example.kakaoshopping.domain.option.Option;
import com.example.kakaoshopping.domain.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

public class CartResponse {
    // W? Cart 도메인의 요청에 대한 응답데이터 담는 class
    // 1. UpdateDTO (static nested class : 외부class와 독립적, 외부class 참조 필요 없음 )
    //    |__ CartDTO (inner class : 외부class와 암묵적 연결, 외부class 없이 멤버class 생성 불가 )
    //
    // 2. FindAllDTO (static nested class)
    //    |__ ProductDTO (inner class)
    //         |__ CartDTO (inner class)
    //              |__ OptionDTO (inner class)
    //
    // 중첩 클래스를 사용하는 이유 --> 하나의 도메인에 다량의 DTO파일이 생성되어 관리의 어려움을 해결하기 위해 사용

    @Getter @Setter
    public static class UpdateDTO{ // 정적 중첩 클래스, CartResponse Class의 정적 멤버처럼 동작
        private List<CartDTO> carts;
        private int totalPrice;
        public UpdateDTO(List<Cart> cartList){ // 생성자
            this.carts = cartList.stream().map(CartDTO::new).collect(Collectors.toList());
            this.totalPrice = cartList.stream().mapToInt(cart -> cart.getOption().getPrice() * cart.getQuantity()).sum();
        }

        @Getter @Setter
        public class CartDTO{ // UpdateDTO.CartDTO
            private int cartId;
            private int optionId;
            private String optionName;
            private int quantity;
            private int price;

            public CartDTO(Cart cart){ //CartDTO 생성자
                this.cartId = cart.getId();
                this.optionId = cart.getOption().getId();
                this.optionName = cart.getOption().getOptionName();
                this.quantity = cart.getQuantity();
                this.price = cart.getOption().getPrice() * cart.getQuantity();
            }
        }
    }

    @Getter @Setter
    public static class FindAllDTO{ //CartResponse 클래스의 정적 중첩 클래스(정적 멤버처럼 동작)
        private List<ProductDTO> products;
        private int totalPrice;

        public FindAllDTO(List<Cart> cartList){ // FindAllDTO 생성자
            this.products = cartList.stream()
                    .map(cart -> cart.getOption().getProduct()).distinct()
                    .map(product -> new ProductDTO(cartList, product)).collect(Collectors.toList());
            this.totalPrice = cartList.stream().mapToInt(cart -> cart.getOption().getPrice() * cart.getQuantity()).sum();
        }

        @Getter @Setter
        public class ProductDTO {  //FindAllDTO.ProductDTO
            private int id;
            private String productName;
            private List<CartDTO> carts;

            public ProductDTO(List<Cart> cartList, Product product){
                this.id = product.getId();
                this.productName = product.getProductName();
                this.carts = cartList.stream()
                        .filter(cart -> cart.getOption().getProduct().getId() == product.getId())
                        .map(CartDTO::new)
                        .collect(Collectors.toList());
            }

            @Getter @Setter
            public class CartDTO { //FindAllDTO.ProductDTO.CartDTO
                private int id;
                private OptionDTO option;
                private int quantity;
                private int price;

                public CartDTO(Cart cart) { //생성자
                    this.id = cart.getId();
                    this.option = new OptionDTO(cart.getOption());
                    this.quantity = cart.getQuantity();
                    this.price = cart.getOption().getPrice() * cart.getQuantity();
                }

                @Getter @Setter
                public class OptionDTO { //FindAllDTO.ProductDTO.CartDTO.OptionDTO
                    private int id;
                    private String optionName;
                    private int price;

                    public OptionDTO(Option option) {
                        this.id = option.getId();
                        this.optionName = option.getOptionName();
                        this.price = option.getPrice();
                    }
                }
            }
        }

    }
}
