package com.example.kakaoshopping._core.errors;

import com.example.kakaoshopping._core.errors.exception.Exception400;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;


// Aspect : Pointcut + Advice의 결합
// 어떤 poincut 메소드에 대해 어떤 advice 메소드를 실행할지 결정
@Aspect
@Component
public class GeneralValidationHandler {

    // Pointcut : 필터링된 joinpoint 의미
    // 여러 갈래의 비즈니스 메소드 중 특정 메소드에서만 횡단 관심에 해당하는
    // 공통 기능을 수행시키기 위해 이용된다.
    // 이를 통해 메소드가 포함된 class, package, method signature 까지 정밀하게 지정 가능
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping(){
    }

    // advice : 횡단 관심에 헤당하는 공통 기능 코드 의미
    // postMapping() 메소드가 실행되기 이전에 실행
    @Before("postMapping()")
    public void validationAdvice(JoinPoint jp){
        // postMapping때 400error에 대한 로직 처리 ?
        Object[] args = jp.getArgs();
        for(Object arg : args){
            if(arg instanceof Errors){
                Errors errors = (Errors)arg;

                if(errors.hasErrors()){
                    throw new Exception400(errors.getFieldErrors().get(0).getDefaultMessage()
                                            + ":" + errors.getFieldErrors().get(0).getField()
                    );
                }
            }
        }
    }

}