package com.example.kakaoshopping.domain.product;

import com.example.kakaoshopping.dto.ProductResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductJPARepository extends JpaRepository<Product,Integer> {

    List<Product> findAll();

}
