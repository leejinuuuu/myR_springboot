package com.test.test.repository;

import com.test.test.entity.TestIngredientEntity;

public interface TestIngredientRepositoryCustom {
    TestIngredientEntity searchByName(String name);

    String countNum();
}
