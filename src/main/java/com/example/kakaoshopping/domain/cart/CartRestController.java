package com.example.kakaoshopping.domain.cart;

 
import com.example.kakaoshopping.dto.CartSaveRequestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class CartRestController {

    private CartService cartService;

    // (기능8) 장바구니 담기
    //TODO @PostMapping("/carts/add")
    @PostMapping("/carts/add")
    public List<Long> saveCart(@RequestBody List<CartSaveRequestDto> requestDto){
       List<Cart> Carts =
        return cartService.saveAll(requestDto);
    }

    // (기능11) 주문하기 - (장바구니 업데이트)
    // TODO @PostMapping("/carts/update")

    // (기능9) 장바구니 보기 - (주문화면, 결재화면)
    // TODO @GetMapping("/carts")

    // 장바구니 비우기
    // TODO : @PostMapping("/carts/clear")
}
