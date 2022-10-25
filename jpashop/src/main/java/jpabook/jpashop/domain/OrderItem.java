package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;
    
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id") // foreign key를 order_id로
    private Order order;
    
    private int orderPrice; // 주문 가격
    private int count; // 주문 수량
}
