package com.test.test.tables;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient {
    public String ingredient_uuid;
    public String ingredient_name;
    public String ingredient_image;

    public Ingredient(
            String ingredient_uuid,
            String ingredient_name,
            String ingredient_image) {
        this.ingredient_uuid = ingredient_uuid;
        this.ingredient_name = ingredient_name;
        this.ingredient_image = ingredient_image;
    }
}