package com.security.jwt.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "user_tbl")
public class User {

    @Id @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, unique = true)
    private String email;

    @Column(length = 20)
    private String nickname;

    private int age;

    @Column(length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String email, String nickname, int age, String password, Role role) {
        this.email = email;
        this.nickname = nickname;
        this.age = age;
        this.password = password;
        this.role = role;
    }


    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }
}
