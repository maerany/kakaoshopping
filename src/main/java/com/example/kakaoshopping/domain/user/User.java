package com.example.kakaoshopping.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity(name = "user_tb")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    /*
        @Getter : lombok annotation, getter 메소드 자동 생성
        @NoArgsConstructor : lombok annotation, 생성자 자동 생성
        @Entity(name = xxx) : 해당하는 Entity class와 매핑될 table명 명시
        @Table : 해당 annotation에서도 table명 명시 가능함,
                 uniqueConstrains = @UniqueConstraint(columnNames = "컬럼명")으로 Unique제약조건 지정

     */

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 256, nullable = false)
    private String password;

    @Column(length = 45, nullable = false)
    private String username;

    // columnDefinition으로 길이랑 null여부 작성 가능함 Default 설정은 해당 속성만 사용
    @Column(length = 45, columnDefinition = "DEFAULT NULL")
    private String roles;

}
