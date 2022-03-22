package com.test.test.service;

import java.util.List;
import java.util.Map;

import com.test.test.tables.IngredientDTO;

public interface IngredientService {
    public List<IngredientDTO> listIngredient(Map<String, String> map);

    public String insertIngredient(Map<String, String> map);

    public String updateIngredient(Map<String, String> map);

    public IngredientDTO detailIngredient(Map<String, String> map);

    public String deleteIngredient(Map<String, String> map);
}
