package com.example.kakaoshopping.domain.order;

import com.example.kakaoshopping.domain.product.Option;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "item_tb")
@Table(indexes = {
          @Index(name = "item_option_id_idx", columnList = "option_id"),
          @Index(name = "item_order_id_idx", columnList = "order_id")
      })
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "option_id", nullable = false)
    private Option optionId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order orderId;

}
