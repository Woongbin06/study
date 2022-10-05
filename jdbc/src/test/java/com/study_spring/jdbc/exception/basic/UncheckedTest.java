package com.study_spring.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class UncheckedTest {

    @Test
    void unchecked_catch() {
        Service service = new Service();
        service.callCheck();
    }

    @Test
    void unchecked_throw() {
        Service service = new Service();

        assertThatThrownBy(() -> service.callThrow())
                .isInstanceOf(MyUncheckedException.class);
    }

    static class MyUncheckedException extends RuntimeException {
        public MyUncheckedException(String message) {
            super(message);
        }
    }

    // UnChecked 예외는 예외를 잡거나 던지지 않아도 됨.
    // 잡지 않으면 자동으로 던짐.
    static class Service {
        Repository repository = new Repository();

        // 필요한 경우 잡으면 됨.
        public void callCheck() {
            try {
                repository.call();
            } catch (MyUncheckedException e) {
                log.info("예외 처리, message={}", e.getMessage(), e);
            }
        }

        // 예외를 잡지 않아도 됨. 왜? 언체크 예외라서.
        public void callThrow() {
            repository.call();
        }
    }

    // throw를 생략해도 됨
    static class Repository {
        public void call() {
            throw new MyUncheckedException("ex");
        }
    }
}
