package com.example.kakaoshopping.domain.cart;

import com.example.kakaoshopping.dto.CartSaveRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository  extends JpaRepository<Cart,Integer> {

}
