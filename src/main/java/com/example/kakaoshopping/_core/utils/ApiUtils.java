package com.example.kakaoshopping._core.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

// Api의 succes/error에 대한 message 생성
public class ApiUtils {

    // ApiUtils.success()를 통해서 success message 생성
    public static <T> ApiResult<T> success(T response){
        // 성공시 ApiResult class(정적 충첩 class)만 사용
        return new ApiResult(true, response, null);
    }

    // ApiUtils.error()를 통해서 error message 생성
    public static ApiResult<?> error(String message, HttpStatus status){
        // 실패시 ApiRsult와 ApiError class 사용해서 toString 만듦
        return new ApiResult<>(false, null, new ApiError(message, status.value()));
    }

    @Getter @Setter
    @AllArgsConstructor
    public static class ApiResult<T>{
        private final boolean success;
        private final T response;
        private final ApiError error;

        @Override
        public String toString(){
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("success", success)
                    .append("response", response)
                    .append("error", error)
                    .toString();
        }
    }

    @Getter @Setter @AllArgsConstructor
    public static class ApiError{
        private final String message;
        private final int status;

        @Override
        public String toString(){
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("message", message)
                    .append("status", status)
                    .toString();
        }
    }

}
