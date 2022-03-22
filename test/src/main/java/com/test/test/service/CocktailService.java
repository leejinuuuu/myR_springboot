package com.test.test.service;

import java.util.List;
import java.util.Map;

import com.test.test.tables.CocktailDTO;

public interface CocktailService {
    List<CocktailDTO> listCocktail(Map<String, String> map);

    List<CocktailDTO> listStdCocktail(Map<String, String> map);

    String insertCocktail(Map<String, String> map);

    String updateCocktail(Map<String, String> map);

    CocktailDTO detailCocktail(Map<String, String> map);

    String deleteCocktail(Map<String, String> map);
}
