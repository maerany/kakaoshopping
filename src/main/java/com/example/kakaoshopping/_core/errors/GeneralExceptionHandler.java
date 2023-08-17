package com.example.kakaoshopping._core.errors;

import com.example.kakaoshopping._core.errors.exception.*;
import com.example.kakaoshopping._core.utils.ApiUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 @ControllerAdvice : 클래스 경로 검색하여 오류를 캐치하는 구현 class 생성 도움
 @Controller 류가 선언된 class들에서 발생한 예외를 감지하고 적절한 응답 만들 때 사용
 비지니스 로직에서 생성된 예외를 catch 해서 그에 맞게 예외처리 진행
 */
@ControllerAdvice
public class GeneralExceptionHandler {

    // @Controller / @RestController가 적용된 Bean 내에 발생하는 예외를
    // 감지하여 발생한 예외 상황에 맞는 메소드로 예외처리를 진행하는 것
    // 비지니스 로직과 예외 처리 로직을 분리하기 위함
    // @ExceptionalHandler(catch하고자하는 예외class)
    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> badRequest(Exception400 e){
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception401.class)
    public ResponseEntity<?> unAuthorized(Exception401 e){
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception403.class)
    public ResponseEntity<?> forbidden(Exception403 e){
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> notFound(Exception404 e){
        return new ResponseEntity<>(e.body(), e.status());
    }

    @ExceptionHandler(Exception500.class)
    public ResponseEntity<?> serverError(Exception500 e){
        return new ResponseEntity<>(e.body(), e.status());
    }

    // Exception500이랑 같은 거 아닌가?^_^;;
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> unknownServerError(Exception e){
        ApiUtils.ApiResult<?> apiResult = ApiUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(apiResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
