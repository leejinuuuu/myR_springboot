package com.test.test.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.test.data;
import com.test.test.entity.TestDataEntity;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

import static com.test.test.entity.QTestDataEntity.testDataEntity;;

@Repository
@RequiredArgsConstructor
public class TestDataRepositoryImpl implements TestDataRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final EntityManagerFactory factory;

    @Override
    public ArrayList<TestDataEntity> findAll() {

        // String sql = "insert into data(uuid, title, content) values
        // ('data0_uuid','data0_title','data0_content')";
        // String sql = "select * from data";
        // Query query = factory.createEntityManager().createNativeQuery(sql,
        // data.class);

        // System.out.println("query.getFirstResult() - " + query.getFirstResult());

        List<Tuple> list = queryFactory
                .select(
                        testDataEntity.title,
                        testDataEntity.content)
                .from(testDataEntity)
                .fetch();

        ArrayList<TestDataEntity> value = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            value.add(
                    new TestDataEntity(list.get(i).get(testDataEntity.uuid), list.get(i).get(testDataEntity.title),
                            list.get(i).get(testDataEntity.content)));
        }

        return value;
    }

}
