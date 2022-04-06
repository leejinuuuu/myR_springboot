package com.test.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "data")
public class TestDataEntity {
    @Id
    @GenericGenerator(name = "USER_GENERATOR", strategy = "uuid")
    private String uuid;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Builder
    public TestDataEntity(String uuid, String title, String content) {
        this.uuid = uuid;
        this.title = title;
        this.content = content;
    }
}
