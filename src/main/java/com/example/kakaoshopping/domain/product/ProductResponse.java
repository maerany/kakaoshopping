package com.example.kakaoshopping.domain.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

public class ProductResponse {

    @Getter @Setter
    public static class FindAllDTO{
        private List<ProductDTO> products;

        // W? 나중에 페이징 처리하면 페이징 처리 할 필드 정도 들어오겠지?

        public FindAllDTO(List<Product> productList){
            this.products = productList.stream().map(ProductDTO::new).collect(Collectors.toList());
        }

        @Getter @Setter
        public class ProductDTO {

            private int productId;
            private String productName;
            private String description;
            private String image;
            private int price;

            public ProductDTO(Product product) {
                this.productId = product.getId();
                this.productName = product.getProductName();
                this.description = product.getDescription();
                this.image = product.getImage();
                this.price = product.getPrice();
            }
        }
    }

}
