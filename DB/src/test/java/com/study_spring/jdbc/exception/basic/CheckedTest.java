package com.study_spring.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class CheckedTest {

    @Test
    void checked_catch() {
        Service service = new Service();
        service.callCatch();
    }

    @Test
    void Checked_throw() {
        Service service = new Service();

        Assertions.assertThatThrownBy(() -> service.callThrow())
                .isInstanceOf(MyCheckedException.class);
    }

    static class MyCheckedException extends Exception {
        public MyCheckedException(String message) {
            super(message);
        }
    }

    /*
    * Checked 예외는
    * 예외를 잡아서 처리하거나, 던지거나 둘 중하나를 해야함.
    * */
    static class Service {
        Repository repository = new Repository();

        // 예외를 잡아서 처리하는 코드

        public void callCatch() {
            try {
                repository.call();
            } catch (MyCheckedException e) {
                log.info("예외 처리, message={}", e.getMessage(), e);
            }
        }

        /*
        * 체크 예외를 밖으로 던짐
        * 체크 예외를 잡지 않고 던지려면 throws 예외를 메서드에 필수 선언
        * */
        public void callThrow() throws MyCheckedException {
            repository.call();
        }
    }

    static class Repository {
        public void call() throws MyCheckedException {
            throw new MyCheckedException("ex");
        }
    }
}
