package com.example.kakaoshopping.domain.cart;

import com.example.kakaoshopping.dto.CartSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;

    public List<Long> saveAll(List<CartSaveRequestDto> requestDto){
        return cartRepository.saveAll(requestDto);
    }
}
