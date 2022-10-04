package com.study_spring.jdbc.exception.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;
import java.sql.SQLException;

public class CheckedAppTest {

    @Test
    void checked() {
        Controller controller = new Controller();
        Assertions.assertThatThrownBy(() -> controller.request())
                .isInstanceOf(Exception.class);
    }

    static class Controller {
        Service service = new Service();

        public void request() throws SQLException, ConnectException {
            service.logic();
        }
    }

    static class Service {
        Repository repository = new Repository();
        NetworkClient networkClient = new NetworkClient();

        // Service는 SQLException에 의존하게 됨. -> 의존관계에 대해 문제 발생
        public void logic() throws SQLException, ConnectException{
            repository.call();
            networkClient.call();
        }
    }

    static class NetworkClient {
        public void call() throws ConnectException {
            throw new ConnectException("연결 실패"); // 예외 던지기
        }
    }

    static class Repository {
        public void call() throws SQLException {
            throw new SQLException("ex"); // 예외 던지기
        }
    }

}
