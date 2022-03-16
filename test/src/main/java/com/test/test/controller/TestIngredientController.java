package com.test.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.test.mybatis.MyMapper;
import com.test.test.tables.IngredientDTO;
import com.test.test.tables.LimitDTO;

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
@RequestMapping("ig")
public class TestIngredientController {

    @Autowired
    private MyMapper mMapper;

    // 재료
    @GetMapping("ls")
    public List<IngredientDTO> listIngredient(
            @RequestBody LimitDTO limit) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("start", limit.getStart());
        map.put("end", limit.getEnd());

        List<IngredientDTO> result = null;
        try {
            result = mMapper.listIngredient(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @PostMapping("add")
    public String insertIngredient(
            @RequestBody IngredientDTO ingredient) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("ingredient_name", ingredient.getIngredient_name());
        map.put("ingredient_image", ingredient.getIngredient_image());

        String result = "fail";
        try {
            mMapper.insertIngredient(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("")
    public IngredientDTO detailIngredient(
            @RequestBody IngredientDTO ingredient) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("ingredient_uuid", ingredient.getIngredient_uuid());

        IngredientDTO result = null;
        try {
            result = mMapper.detailIngredient(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @DeleteMapping("")
    public String deleteIngredient(
            @RequestBody IngredientDTO ingredient) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("ingredient_uuid", ingredient.getIngredient_uuid());

        String result = "fail";
        try {
            mMapper.deleteIngredient(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
