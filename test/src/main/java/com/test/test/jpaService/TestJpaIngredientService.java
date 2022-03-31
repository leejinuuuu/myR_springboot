package com.test.test.jpaService;

import java.util.List;

import com.test.test.entity.TestIngredientEntity;
import com.test.test.repository.TestIngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestJpaIngredientService {
    @Autowired
    private TestIngredientRepository ingredientRepository;

    public void srXX() throws Exception {
        List<TestIngredientEntity> list = ingredientRepository.findAll();
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).getIngredient_name());
    }

}
