package com.study_spring.jdbc.domain;

import lombok.Data;

@Data
public class Member {

    private String memberId;
    private int money;

    public Member() {

    }

    public Member(String member_id, int money) {
        this.memberId = member_id;
        this.money = money;
    }
}
