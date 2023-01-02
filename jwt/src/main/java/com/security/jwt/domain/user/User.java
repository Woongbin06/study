package com.security.jwt.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "User_tbl")
public class User {

    @Id @Column(name = "user_id")
    private Long id;

    @Column(length = 30, unique = true)
    private String email;

    @Column(length = 20)
    private String nickname;

    private int age;

    @Column(length = 20)
    private String password;

    @Builder
    public User(String email, String nickname, int age, String password) {
        this.email = email;
        this.nickname = nickname;
        this.age = age;
        this.password = password;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }
}
