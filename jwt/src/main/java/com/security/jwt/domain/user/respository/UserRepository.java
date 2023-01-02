package com.security.jwt.domain.user.respository;

import com.security.jwt.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 중복되는 이메일 찾을 때 사용.
    Optional<Member> findByEmail(String email);
}
