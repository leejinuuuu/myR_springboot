package com.test.test.tables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {
    public String ingredient_uuid;
    public String ingredient_name;
    public String ingredient_image;
}