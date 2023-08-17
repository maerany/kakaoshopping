package com.example.kakaoshopping.domain.cart;

import com.example.kakaoshopping._core.errors.exception.Exception400;
import com.example.kakaoshopping._core.errors.exception.Exception404;
import com.example.kakaoshopping._core.errors.exception.Exception500;
import com.example.kakaoshopping.domain.user.User;
import com.example.kakaoshopping.dto.CartSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CartListService {

    private final CartJPARepository cartJPARepository;
    @Transactional
    public CartResponse.UpdateDTO update(List<CartRequest.UpdateDTO> requestDTOs, User user){
        List<Cart> cartList = cartJPARepository.findAllByUserId(user.getId());

        List<Integer> cartIds = cartList.stream().map(cart -> cart.getId()).collect(Collectors.toList());
        List<Integer> requestIds = requestDTOs.stream().map(dto -> dto.getCartId()).collect(Collectors.toList());

        if(cartIds.size() == 0){
            throw new Exception404("주문할 장바구니 상품이 없습니다");
        }

        if(requestIds.stream().distinct().count() != requestIds.size()){
            throw new Exception400("동일한 장바구니 아이디를 주문할 수 없습니다");
        }

        for(Integer requestId : requestIds){
            if(!cartIds.contains(requestId)){
                throw new Exception400("장바구니에 없는 상품은 주문할 수 없습니다 :" + requestId);
            }
        }

        for(CartRequest.UpdateDTO updateDTO : requestDTOs){
            for(Cart cart : cartList){
                if(cart.getId() == updateDTO.getCartId()){
                    cart.update(updateDTO.getQuantity(), cart.getPrice() * updateDTO.getQuantity());
                }
            }
        }

        return new CartResponse.UpdateDTO(cartList);
    }

    public CartResponse.FindAllDTO findAll(User user){
        List<Cart> cartLists = cartJPARepository.findByUserIdOrderByOptionIdAsc(user.getId());
        return new CartResponse.FindAllDTO(cartLists);
    }

    @Transactional
    public void clear(User user){
        try{
            cartJPARepository.deleteByUserId(user.getId());
        } catch (Exception e){
            throw new Exception500("장바구니 비우기 실패 : " + e.getMessage());
        }
    }




}
