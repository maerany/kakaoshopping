package com.example.kakaoshopping._core.errors.exception;

import com.example.kakaoshopping._core.utils.ApiUtils;
import org.springframework.http.HttpStatus;

public class Exception403 extends RuntimeException{
// forbidden
// 서버가 요청을 이해했지만 권한이 없어서 요청을 승인하지 않음

    public Exception403(String message){
        super(message);
    }
    public ApiUtils.ApiResult<?> body(){
        return ApiUtils.error(getMessage(), HttpStatus.FORBIDDEN);
    }

    public HttpStatus status(){
        return HttpStatus.FORBIDDEN;
    }
}
