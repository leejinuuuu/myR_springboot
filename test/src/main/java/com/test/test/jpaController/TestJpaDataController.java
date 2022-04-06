package com.test.test.jpaController;

import com.test.test.jpaService.TestJpaDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "jpa")
public class TestJpaDataController {
    @Autowired
    TestJpaDataService ingredientService;

    @GetMapping(value = "data/list")
    public void list() throws Exception {
        ingredientService.findDataAll();
    }
}
