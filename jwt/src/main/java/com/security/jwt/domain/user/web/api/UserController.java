package com.security.jwt.domain.user.web.api;

import com.security.jwt.domain.user.service.UserService;
import com.security.jwt.domain.user.web.dto.request.UserSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Long singUp(@Valid @RequestBody UserSignUpRequestDto request) throws Exception {
        return userService.signUp(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        return userService.login(user);
    }
}
