package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @JsonIgnore // 양방향 연관관계에서는 둘 중에 하나에 해줘야 댐.6
    @OneToMany(mappedBy = "member") // 1 : n 관계 | 연관관계의 주인
    private List<Order> orders = new ArrayList<>();


}
