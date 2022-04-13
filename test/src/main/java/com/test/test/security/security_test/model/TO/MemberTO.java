package com.test.test.security.security_test.model.TO;

import java.time.LocalDateTime;

import com.test.test.security.security_test.model.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberTO {

    private Integer id;

    private String name;

    private String account;

    private String password;

    private LocalDateTime lastAccessDt;

    private LocalDateTime regDt;

    public Member toEntity() {
        return new Member(id, name, account, password);
    }
}