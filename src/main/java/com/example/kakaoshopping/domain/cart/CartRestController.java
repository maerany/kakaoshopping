package com.example.kakaoshopping.domain.cart;

 
import com.example.kakaoshopping._core.config.security.CustomUserDetails;
import com.example.kakaoshopping._core.utils.ApiUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.event.CaretListener;
import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class CartRestController {

    private final CartListService cartListService;

    // (기능8) 장바구니 담기
    //TODO @PostMapping("/carts/add")
//    public ResponseEntity<?> add(){
//
//    }

    // (기능11) 주문하기 - (장바구니 업데이트)
    // TODO @PostMapping("/carts/update")
    @PostMapping("/carts/update")
    public ResponseEntity<?> update(@RequestBody @Valid List<CartRequest.UpdateDTO> requestDTOs
                                    , Errors errors
                                    , @AuthenticationPrincipal CustomUserDetails userDetails){
        CartResponse.UpdateDTO responseDTO = cartListService.update(requestDTOs, userDetails.getUser());
        ApiUtils.ApiResult<?> apiResult = ApiUtils.success(responseDTO);
        // W? java 자료형이 자동으로 JSON 객체나 배열로 변환되는감?
        return ResponseEntity.ok(apiResult);
    }


    // (기능9) 장바구니 보기 - (주문화면, 결재화면)
    // TODO @GetMapping("/carts")
    @GetMapping("/carts")
    public ResponseEntity<?> findAll(@AuthenticationPrincipal CustomUserDetails userDetails){
        CartResponse.FindAllDTO responseDTO = cartListService.findAll(userDetails.getUser());
        ApiUtils.ApiResult<?> apiResult = ApiUtils.success(responseDTO);
        return ResponseEntity.ok(apiResult);
    }

    // 장바구니 비우기
    // TODO : @PostMapping("/carts/clear")
    public ResponseEntity<?> clear(@AuthenticationPrincipal CustomUserDetails userDetails){
        cartListService.clear(userDetails.getUser());
        ApiUtils.ApiResult<?> apiResult = ApiUtils.success(null);
        return ResponseEntity.ok(apiResult);
    }
}
