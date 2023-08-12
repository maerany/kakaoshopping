package com.example.kakaoshopping._core.errors.exception;

import com.example.kakaoshopping._core.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Exception404 extends RuntimeException {
    // not found
    // 원서버가 대상 리소스에 대한 표현을 찾지 못하거나 존재 여부를 공개하지 않으려는 것

    public Exception404(String message){
        super(message);
    }

    public ApiUtils.ApiResult<?> body(){
        return ApiUtils.error(getMessage(), HttpStatus.NOT_FOUND);
    }

    public HttpStatus status(){
        return HttpStatus.NOT_FOUND;
    }
}
