package com.test.test.controller;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

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

    // 사진을 저장할 때 프로젝트 내부에 저장하면, 프로젝트가 무거워지는 단점이 존재하기에
    // 외부에 따로 파일을 만들어서 관리한다.
    // C:\Users\jinw8\Desktop/single
    String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
    String basePath = rootPath + "/" + "springboot_upload";

    @PostMapping("add")
    public String insertIngredient(
            @RequestParam("ingredient_bitmap_file") MultipartFile ingredient_bitmap_file,
            @RequestParam("ingredient_name") String ingredient_name,
            @RequestParam("ingredient_image") String ingredient_image) {

        String result = "fail";
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("ingredient_name", ingredient_name);
            map.put("ingredient_image", ingredient_image);

            String originalName = ingredient_bitmap_file.getOriginalFilename();
            String filePath = basePath + "/" + originalName;
            File dest = new File(filePath);
            ingredient_bitmap_file.transferTo(dest);

            mMapper.insertIngredient(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @PostMapping("md")
    public String updateIngredient(
            @RequestParam("aft_ingredient_bitmap_file") MultipartFile aft_ingredient_bitmap_file,
            @RequestParam("aft_ingredient_name") String aft_ingredient_name,
            @RequestParam("aft_ingredient_image") String aft_ingredient_image,
            @RequestParam("ingredient_uuid") String ingredient_uuid) {

        String result = "fail";
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("ingredient_name", aft_ingredient_name);
            map.put("ingredient_image", aft_ingredient_image);

            String originalName = aft_ingredient_bitmap_file.getOriginalFilename();
            String filePath = basePath + "/" + originalName;
            File dest = new File(filePath);
            aft_ingredient_bitmap_file.transferTo(dest);

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
