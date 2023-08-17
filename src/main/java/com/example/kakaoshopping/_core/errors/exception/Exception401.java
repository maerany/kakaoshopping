package com.example.kakaoshopping._core.errors.exception;

import com.example.kakaoshopping._core.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Exception401 extends RuntimeException{
//unauthorized
// 클라이언트가 요청한 리소스에 접근하기 위한 유효한 인증 자격 증명(인증 정보)이 부족하거나 잘못되었음

    public Exception401(String message){
        super(message);
    }

    public ApiUtils.ApiResult<?> body(){
        return ApiUtils.error(getMessage(), HttpStatus.UNAUTHORIZED);
    }

    public HttpStatus status(){
        return HttpStatus.UNAUTHORIZED;
    }
}
