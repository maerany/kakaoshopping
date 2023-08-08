package com.example.kakaoshopping.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false, unique = true)
    private String email; // 인증시 필요한 필드
    @Column(length = 256, nullable = false)
    private String password;
    @Column(length = 45, nullable = false)
    private String username;

    @Column(length = 30)
    @Convert(converter = StringArrayConverter.class)
    private List<String> roles = new ArrayList<>(); // role은 한 개 이상

    @Builder
    public User(int id, String email, String password, String username, List<String> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

}
