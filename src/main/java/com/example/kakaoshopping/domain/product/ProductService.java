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

    private final ProductJPARepository productJPARepository;

    public ProductResponse.FindAllDTO findAll(){
        List<Product> productLists = productJPARepository.findAll();
        return new ProductResponse.FindAllDTO(productLists);
    }


}
