package com.example.kakaoshopping.domain.cart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartJPARepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUserId(int userId);
    List<Cart> findByUserIdOrderByOptionIdAsc(int userId);
    List<Cart> deleteByUserId(int userId);

    // 여기서 어떻게 값을 찾아오는 거지?..
}
