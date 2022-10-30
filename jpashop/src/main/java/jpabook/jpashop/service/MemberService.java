package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 읽기에는 readOnly = true로 하면 jpa 성능 증가
@RequiredArgsConstructor // final이 있는 필드만 생성자를 만들어줌.
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    @Transactional // 가입은 수정을 해야 하기때문에 readOnly = false(default)로 해야함
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // 중복회원
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    // 회원 단건 조회
    public Member findById(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
