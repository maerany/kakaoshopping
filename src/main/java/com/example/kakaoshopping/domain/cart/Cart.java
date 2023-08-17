package com.example.kakaoshopping.domain.cart;


import com.example.kakaoshopping.domain.option.Option;
import com.example.kakaoshopping.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "cart_tb")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "option_id"}),
       indexes = {
           @Index(name = "cart_user_id_idx", columnList = "user_id"),
           @Index(name = "cart_option_id_idx", columnList = "option_id")
       })
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * TODO : fetch join 왜 했는지 검색해보기
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // user별로 장바구니에 묶여 있음.
    // 다(cart) : 1(user)

    @OneToOne(fetch = FetchType.LAZY)
    private Option option;
    // 하나의 옵션 객체만 가지는 건가?
    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    /*
        @Builder
         : 객체를 생성하기 위해 생성자를 이용하게 되면 인자값의 순서와 가독성이 어렵다는 단점이 있다.
           이러한 단점을 극복하기 위한 방법으로 Builder 방식을 이용함.
           Builder 패턴으로 생성자를 만들면 어떤 인자에 어떤 값을 넣는 지 가독성이 좋아지며,
           인자의 순서를 신경쓰지 않아도 된다.

           class에 @Builder를 선언하게 되면 모든 매개변수가 생성자의 param으로 들어가고
           객체 생성시 필요없는 매개변수도 builder에 노출이 되는 문제점이 발생함
           -> 이를 해결하기 위해 생성자 위에 @Builder 사용한다.
     */
    @Builder
    public Cart(int id, User user, Option option, int quantity, int price) {
        this.id = id;
        this.user = user;
        this.option = option;
        this.quantity = quantity;
        this.price = price;
    }

    // 장바구니 업데이트
    public void update(int quantity, int price){
        this.quantity = quantity;
        this.price = price;
    }


}
