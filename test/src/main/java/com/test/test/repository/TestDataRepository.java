package com.test.test.repository;

import com.test.test.entity.TestDataEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDataRepository extends JpaRepository<TestDataEntity, String>, TestDataRepositoryCustom {

}
