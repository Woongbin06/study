package com.security.jwt.global.jwt;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.IOException;

/**
 * JwtTokenProvider가 검증을 끝낸 Jwt로부터 유저 정보를 조회해서
 * UserPasswordAuthenticationFilter로  전달.
 */
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Header에서 Jwt를 받아옴.
        String token = jwtProvider.resolveToken(request);

        // 유효한 토큰인지 확인.
        if (token != null && jwtProvider.validateToken(token)) {
            // 토큰으로부터 유저 정보를 가져 옴.
            Authentication authentication = jwtProvider.getAuthentication(token);

            // SecurityContext에 authentication 객체 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

}
