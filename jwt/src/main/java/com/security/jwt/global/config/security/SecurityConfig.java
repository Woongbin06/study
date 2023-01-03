package com.security.jwt.global.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable() // cors 허용 금지
                .csrf().disable() // csrf 허용 금지
                .formLogin().disable() // 폼기반 로그인 인증 허용
                .httpBasic().disable() // http 기반 인증 허용
                // 세션을 사용하지 않게 설정.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests() // 요청에 의한 사용권환 체크
                .antMatchers("/user/login").permitAll() // permitAll() : 인증 없이 허용.
                .antMatchers("/user/join").permitAll()
                .antMatchers("/user").permitAll()
                .anyRequest().authenticated();
    }
}
