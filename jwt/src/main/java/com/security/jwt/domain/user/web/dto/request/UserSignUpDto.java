package com.security.jwt.domain.user.web.dto.request;

import com.security.jwt.domain.user.User;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserSignUpDto {

    // 이메일을 입력하지 않았을 때 해당 내용을 띄어줌.
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "나이를 입력해주세요.")
    @Range(min = 1, max = 120) // 최소 나이와 최대 나이 지정
    private int age;

    @NotBlank(message = "닉네임을 입력해주세요.")
    private String nickname;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    // 비밀번호 패턴 지정.
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
            message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
    private String password;

    @Builder
    public User toEntity(){
        return User.builder()
                .email(email)
                .age(age)
                .nickname(nickname)
                .password(password)
                .build();
    }
}
