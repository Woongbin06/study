package com.study_spring.jdbc.service;

import com.study_spring.jdbc.domain.Member;
import com.study_spring.jdbc.repository.MemberRepositoryV3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;


// 트랜 잭션 - @Transactional AOP
@Slf4j
class MemberServiceV3_3 {
    private  final MemberRepositoryV3 memberRepository;

    public MemberServiceV3_3(MemberRepositoryV3 memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional // 롤백과 커밋을 할 수 있음.
    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        // 비지니스 로직
        bizLogic(fromId, toId, money);
    }

    private void bizLogic( String fromId, String toId, int money) throws SQLException {
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);

        // fromId의 멤버를 조회후 머니를 넣고
        memberRepository.update(fromId, fromMember.getMoney() - money);
        // 검증
        validation(toMember);
        // toId의 멤버를 조회후 머니를 뺌.
        memberRepository.update(toId, toMember.getMoney() + money);
    }
    private static void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }

}

