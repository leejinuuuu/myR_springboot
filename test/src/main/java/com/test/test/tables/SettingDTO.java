package com.test.test.tables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SettingDTO {
    public String settingCocktailWithIngredient_uuid;
    public String cocktail_uuid;
    public String cocktail_name;
    public String ingredient_uuid;
    public String ingredient_name;
    public String vol;
    public String tool;
}
