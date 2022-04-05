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

        System.out.println("count number - " + ingredientRepository.countNum());
        System.out.println("search by name - " + ingredientRepository.searchByName("4_name"));

        List<TestIngredientEntity> list = ingredientRepository.findAll();
        for (int i = 0; i < list.size(); i++)
            System.out.println("find all - i(" + i + ") : " + list.get(i).getIngredient_name());
    }
}
