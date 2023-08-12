package com.example.kakaoshopping._core.utils;

import com.example.kakaoshopping._core.errors.exception.Exception401;
import com.example.kakaoshopping._core.errors.exception.Exception403;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterResponseUtils {

    // HttpServlet 응답과 httpStatus code 401를 받아서 입출력 예외발생을 처리하는 메소드?
    public static void unAuthorized(HttpServletResponse resp, Exception401 e) throws IOException{
        resp.setStatus(e.status().value());
        resp.setContentType("application/json; charset=utf-8");

        // java데이터를 ObjectMapper객체를 통해서 String으로 직렬화
        ObjectMapper om = new ObjectMapper();
        String responseBody = om.writeValueAsString(e.body());
        //resp에서 responseBody변수에 담긴 메시지를 client에게 전송
        resp.getWriter().println(responseBody);
    }

    public static void forbidden(HttpServletResponse resp, Exception403 e) throws IOException{
        //응답 상태값과 응답보낼 contentType 지정
        resp.setStatus(e.status().value());
        resp.setContentType("application/json; charset=utf-8");

        //응답 보낼 java데이터를 ObjectMapper객체를 통해 String 직렬화해서 응답body에 내용 셋팅
        ObjectMapper om = new ObjectMapper();
        String responseBody = om.writeValueAsString(e.body());

        resp.getWriter().println(responseBody);

    }
}
