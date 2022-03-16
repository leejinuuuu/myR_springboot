package com.test.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.test.mybatis.MyMapper;
import com.test.test.tables.CocktailDTO;
import com.test.test.tables.CommentDTO;
import com.test.test.tables.IngredientDTO;
import com.test.test.tables.LimitDTO;
import com.test.test.tables.SettingDTO;
import com.test.test.tables.StandardLsDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("ct")
public class TestCocktailController {

    @Autowired
    private MyMapper mMapper;

    // 칵테일
    @GetMapping("ls")
    public List<CocktailDTO> listCocktail(
            @RequestBody LimitDTO limit) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("start", limit.getStart());
        map.put("end", limit.getEnd());

        List<CocktailDTO> result = null;
        try {
            result = mMapper.listCocktail(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @GetMapping("std")
    public List<CocktailDTO> listStdCocktail(
            @RequestBody StandardLsDTO std) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("show_std", std.getShow_std());
        map.put("show_std_content", std.getShow_std_content());
        map.put("start", std.getStart());
        map.put("end", std.getEnd());

        List<CocktailDTO> result = null;
        try {
            result = mMapper.listStdCocktail(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @PostMapping("add")
    public String insertCocktail(
            @RequestBody CocktailDTO cocktail) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("cocktail_name", cocktail.getCocktail_name());
        map.put("cocktail_writer", cocktail.getCocktail_writer());
        map.put("cocktail_image", cocktail.getCocktail_image());
        map.put("cocktail_explanation", cocktail.getCocktail_explanation());
        map.put("cocktail_glass", cocktail.getCocktail_glass());
        map.put("cocktail_base", cocktail.getCocktail_base());
        map.put("cocktail_source", cocktail.getCocktail_source());

        String result = "fail";
        try {
            mMapper.insertCocktail(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("md")
    public String updateCocktail(
            @RequestBody CocktailDTO cocktail) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("cocktail_uuid", cocktail.getCocktail_uuid());
        map.put("aft_cocktail_name", cocktail.getCocktail_name());
        map.put("aft_cocktail_writer", cocktail.getCocktail_writer());
        map.put("aft_cocktail_image", cocktail.getCocktail_image());
        map.put("aft_cocktail_explanation", cocktail.getCocktail_explanation());
        map.put("aft_cocktail_glass", cocktail.getCocktail_glass());
        map.put("aft_cocktail_base", cocktail.getCocktail_base());
        map.put("aft_cocktail_source", cocktail.getCocktail_source());

        String result = "fail";
        try {
            mMapper.updateCocktail(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("")
    public CocktailDTO detailCocktail(
            @RequestBody CocktailDTO cocktail) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("cocktail_uuid", cocktail.getCocktail_uuid());

        CocktailDTO result = null;
        try {
            result = mMapper.detailCocktail(map);
            result.setSettings(mMapper.detailCocktail_setting(map));
            result.setComments(mMapper.detailCocktail_comment(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @DeleteMapping("")
    public String deleteCocktail(
            @RequestBody CocktailDTO cocktail) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("cocktail_uuid", cocktail.getCocktail_uuid());

        String result = "fail";
        try {
            mMapper.deleteCocktail(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
