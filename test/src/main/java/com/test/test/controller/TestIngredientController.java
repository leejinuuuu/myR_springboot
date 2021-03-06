package com.test.test.controller;

import java.io.File;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.test.Global;
import com.test.test.service.IngredientService;
import com.test.test.tables.IngredientDTO;
import com.test.test.tables.LimitDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Service
@RestController
@RequestMapping("ig")
public class TestIngredientController {

    @Autowired
    private IngredientService ingredientService;

    // 재료
    @GetMapping("ls")
    public List<IngredientDTO> listIngredient(
            @RequestBody LimitDTO limit) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("start", limit.getStart());
        map.put("end", limit.getEnd());

        return ingredientService.listIngredient(map);
    }

    @PostMapping("add")
    public String insertIngredient(
            @RequestParam("ingredient_bitmap_file") MultipartFile ingredient_bitmap_file,
            @RequestParam("ingredient_name") String ingredient_name) {

        String result = "fail";
        try {

            String originalName = ingredient_bitmap_file.getOriginalFilename();
            String filePath = Global.basePath + "/" + originalName;
            String extension = originalName.substring(originalName.length() - 4, originalName.length());

            int i = 1;
            String fileName = filePath;

            while (new File(filePath).exists()) {
                filePath = fileName.substring(0, fileName.length() - 4).concat("(" + i + ")").concat(extension);
                i++;
            }

            File dest = new File(filePath);
            ingredient_bitmap_file.transferTo(dest);

            Map<String, String> map = new HashMap<String, String>();
            map.put("ingredient_name", ingredient_name);
            map.put("ingredient_image", dest.getName());

            result = ingredientService.insertIngredient(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @PostMapping("md")
    public String updateIngredient(
            @RequestParam("aft_ingredient_bitmap_file") MultipartFile aft_ingredient_bitmap_file,
            @RequestParam("aft_ingredient_name") String aft_ingredient_name,
            @RequestParam("ingredient_uuid") String ingredient_uuid) {

        String result = "fail";
        try {
            String originalName = aft_ingredient_bitmap_file.getOriginalFilename();
            String filePath = Global.basePath + "/" + originalName;
            String extension = originalName.substring(originalName.length() - 4, originalName.length());

            int i = 1;
            String fileName = filePath;

            while (new File(filePath).exists()) {
                filePath = fileName.substring(0, fileName.length() - 4).concat("(" + i + ")").concat(extension);
                i++;
            }

            File dest = new File(filePath);
            aft_ingredient_bitmap_file.transferTo(dest);

            Map<String, String> map = new HashMap<String, String>();
            map.put("aft_ingredient_name", aft_ingredient_name);
            map.put("aft_ingredient_image", dest.getName());
            map.put("ingredient_uuid", ingredient_uuid);

            result = ingredientService.updateIngredient(map);
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

        return ingredientService.detailIngredient(map);
    }

    @DeleteMapping("")
    public String deleteIngredient(
            @RequestBody IngredientDTO ingredient) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("ingredient_uuid", ingredient.getIngredient_uuid());

        return ingredientService.deleteIngredient(map);
    }
}
