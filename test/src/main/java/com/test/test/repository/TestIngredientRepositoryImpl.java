package com.test.test.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.test.entity.TestIngredientEntity;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TestIngredientRepositoryImpl implements TestIngredientRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final EntityManagerFactory factory;

    @Override
    public TestIngredientEntity searchByName(String name) {
        Tuple tuple = queryFactory
                .select(
                // ingredient
                )
                .from()
                .where()
                .fetchFirst();
        // return new TestIngredientEntity(tuple.get(), tuple.get());

        return null;
    }

    @Override
    public String countNum() {

        EntityManager em = factory.createEntityManager();
        String sql = "SELECT * FROM ingredient";
        Query query = em.createNativeQuery(sql, TestIngredientEntity.class);

        for (int i = 0; i < query.getResultList().size(); i++) {
            TestIngredientEntity tmp = (TestIngredientEntity) query.getResultList().get(i);
            System.out.println(i + " : " + tmp.getIngredient_name());
        }

        return String.valueOf(query.getResultList());
    }

}
