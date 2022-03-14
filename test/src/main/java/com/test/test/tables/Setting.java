package com.test.test.tables;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Setting {
    public String settingCocktailWithIngredient_uuid;
    public String cocktail_uuid;
    public String cocktail_name;
    public String ingredient_uuid;
    public String ingredient_name;
    public String vol;
    public String tool;

    Setting(
            String settingCocktailWithIngredient_uuid,
            String cocktail_uuid,
            String cocktail_name,
            String ingredient_uuid,
            String ingredient_name,
            String vol,
            String tool) {
        this.settingCocktailWithIngredient_uuid = settingCocktailWithIngredient_uuid;
        this.cocktail_uuid = cocktail_uuid;
        this.cocktail_name = cocktail_name;
        this.ingredient_uuid = ingredient_uuid;
        this.ingredient_name = ingredient_name;
        this.vol = vol;
        this.tool = tool;
    }
}
