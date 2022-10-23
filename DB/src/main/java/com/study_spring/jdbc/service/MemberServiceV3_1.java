package com.study_spring.jdbc.service;

import com.study_spring.jdbc.domain.Member;
import com.study_spring.jdbc.repository.MemberRepositoryV3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.Connection;
import java.sql.SQLException;


// 트랜 잭션 - 트랜잭션 매니저
@RequiredArgsConstructor
@Slf4j
class MemberServiceV3_1 {
    
//    private final DataSource dataSource;
    private final PlatformTransactionManager transactionManager;
    private  final MemberRepositoryV3 memberRepository;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
//        Connection con = dataSource.getConnection();

        // 파라미터로 속성에 관한 걸 넣어줘야함.
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            // 비지니스 로직 connectino 넘길 필요 없음.
            bizLogic(fromId, toId, money);
            // 커밋, 롤백
//            con.commit(); // 성공시 커밋
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
//            con.rollback(); // 실패시 롤백
            throw new IllegalStateException(e);
        }
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
