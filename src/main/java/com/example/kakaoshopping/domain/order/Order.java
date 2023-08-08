package com.example.kakaoshopping.domain.order;

import com.example.kakaoshopping.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "order_tb")
@Table(indexes = @Index(name = "order_user_id_idx", columnList = "user_id"))
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Order(int id, User user) {
        this.id = id;
        this.user = user;
    }

}
