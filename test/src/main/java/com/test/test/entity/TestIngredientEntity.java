package com.test.test.entity;

import javax.persistence.*;

import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ingredient")
public class TestIngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredient_uuid")
    private String ingredient_uuid;

    @Column(name = "ingredient_name")
    private String ingredient_name;

    @Column(name = "ingredient_image")
    private String ingredient_image;

    @Builder
    TestIngredientEntity(String ingredient_name, String ingredient_image) {
        this.ingredient_name = ingredient_name;
        this.ingredient_image = ingredient_image;
    }
}
