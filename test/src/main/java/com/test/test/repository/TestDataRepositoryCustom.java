package com.test.test.repository;

import java.util.ArrayList;

import com.test.test.entity.TestDataEntity;

public interface TestDataRepositoryCustom {
    ArrayList<TestDataEntity> findAll();
}
