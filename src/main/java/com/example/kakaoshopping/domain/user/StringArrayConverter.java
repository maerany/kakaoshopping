package com.example.kakaoshopping.domain.user;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


//  java -> DB
//  Db   -> java
//  데이터 형식을 바꿀 때 사용하는 인터페이스
//  AttributeConverter< X, Y>
//  X == javaDataType / Y == dbDataType
@Converter
public class StringArrayConverter implements AttributeConverter<List<String>, String> {

    private static final String SPLIT_CHAR = ",";
    // java에서는 List로  roles를 가지고 있고, DB에는 구분자(,)로 하나의 string으로 가지고 있다는 뜻?

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        // table에 insert or update 시 호출
        return attribute.stream().map(String::valueOf).collect(Collectors.joining(SPLIT_CHAR));
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        // table에서 select 시 호출
        if(dbData == null) { // JPA save는 select부터 하기 때문에, null을 체크해줘야 한다.
            return Collections.emptyList();
        } else {
            return Arrays.stream(dbData.split(SPLIT_CHAR))
                    .map(String::valueOf)
                    .collect(Collectors.toList());
        }
    }
}
