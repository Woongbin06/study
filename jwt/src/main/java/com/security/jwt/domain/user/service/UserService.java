package com.security.jwt.domain.user.service;

import com.security.jwt.domain.user.User;
import com.security.jwt.domain.user.respository.UserRepository;
import com.security.jwt.domain.user.web.dto.request.UserSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // readOnly가 true되어있기 때문에 @Transactional을 써줘야 false가 됌.
    @Transactional
    public Long signUp(UserSignUpRequestDto request) throws Exception {

        // 중복 이메일이 있는지 검사
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일 입니다.");
        }

        User user = userRepository.save(request.toEntity());
        // 비밀번호 암호화
        user.encodePassword(passwordEncoder);

        return user.getId();
    }
}
