package com.example.kakaoshopping._core.errors.exception;

import com.example.kakaoshopping._core.utils.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Exception400 extends RuntimeException{
//client validation failure / wrong parameter
//서버가 요청을 처리하지 못하거나 처리하지 않을 것임
//ExceptionXXX클래스의 body() 호출 -> 메세지와 Http상태코드
//                   status() 호출 -> Http 상태코드

    // Ecxeption400 객체 생성시 message를 받아서 RuntimeException에 전달
    public Exception400(String message){
        super(message);
    }

    public ApiUtils.ApiResult<?> body(){
        // getMessage() : 예외 객체의 메시지 반환 메소드 / BAD_REQUEST == 400
        return ApiUtils.error(getMessage(), HttpStatus.BAD_REQUEST);
    }

    public HttpStatus status(){
        return HttpStatus.BAD_REQUEST;
    }
}
