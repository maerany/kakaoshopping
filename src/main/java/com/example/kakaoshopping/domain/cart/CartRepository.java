package com.example.kakaoshopping.domain.cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository  extends JpaRepository<Cart,Integer> {
}
