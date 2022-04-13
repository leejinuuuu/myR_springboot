package com.test.test.security.security_test.service;

import com.test.test.security.security_test.model.TO.MemberTO;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {
    Integer save(MemberTO memberTO);
}