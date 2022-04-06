package com.test.test.jpaService;

import java.util.ArrayList;

import com.test.test.entity.TestDataEntity;
import com.test.test.repository.TestDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestJpaDataService {
    @Autowired
    private TestDataRepository testDataRepository;

    public void findDataAll() throws Exception {
        ArrayList<TestDataEntity> list = testDataRepository.findAll();

        for (int i = 0; i < list.size(); i++)
            System.out.println("find all - i(" + i + ") : " + list.get(i).getTitle());

        testDataRepository.saveAndFlush(new TestDataEntity("data1_uuid", "data1_title", "data1_content"));
    }
}
