package com.example.kakaoshopping.domain.product;


import com.example.kakaoshopping.domain.option.Option;
import com.example.kakaoshopping.domain.option.OptionJPARepository;
import com.example.kakaoshopping.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final OptionJPARepository optionJPARepository;

    public List<Product> findProducts(){
        return productRepository.findAll();
    }

    public List<Option> findByProductId(int productId){
         return optionJPARepository.findByProductId(productId);
    }
}
