package com.study_spring.jdbc.repository;

import com.study_spring.jdbc.domain.Member;

import java.sql.SQLException;

public interface MemberRepositoryEX {
    Member save(Member member) throws SQLException;

    Member findById(String memberId) throws SQLException;

    void update(String memberId, int money) throws SQLException;

    void delete(String memberId) throws SQLException;
}
