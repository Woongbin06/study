package com.study_spring.jdbc.service;

import com.study_spring.jdbc.domain.Member;
import com.study_spring.jdbc.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@RequiredArgsConstructor
public class MemberServiceV1 {

    private  final MemberRepositoryV2 memberRepository;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);

        // fromId의 멤버를 조회후 머니를 넣고
        memberRepository.update(fromId, fromMember.getMoney() - money);
        // 검증
        validation(toMember);
        // toId의 멤버를 조회후 머니를 뺌.
        memberRepository.update(toId, toMember.getMoney() + money);

        // 커밋, 롤백

    }

    private static void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }

}
