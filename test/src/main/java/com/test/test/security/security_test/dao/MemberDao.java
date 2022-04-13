package com.test.test.security.security_test.dao;

import java.util.Optional;

import com.test.test.security.security_test.model.entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member, Integer> {
    Optional<Member> findByAccount(String account);
}