package com.test.test.repository;

import com.test.test.entity.TestIngredientEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestIngredientRepository
        extends JpaRepository<TestIngredientEntity, String>, TestIngredientRepositoryCustom {

}
