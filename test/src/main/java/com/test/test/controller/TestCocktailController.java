package com.test.test.controller;

import javax.swing.filechooser.FileSystemView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.test.data;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    // 사진을 저장할 때 프로젝트 내부에 저장하면, 프로젝트가 무거워지는 단점이 존재하기에
    // 외부에 따로 파일을 만들어서 관리한다.
    // C:\Users\jinw8\Desktop/single
    String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
    String basePath = rootPath + "/" + "upload_files_with_server/springboot/";

    @PostMapping("add")
    public String insertCocktail(
            @RequestParam("cocktail_bitmap_file") MultipartFile cocktail_bitmap_file,
            @RequestParam("cocktail_name") String cocktail_name,
            @RequestParam("cocktail_writer") String cocktail_writer,
            @RequestParam("cocktail_explanation") String cocktail_explanation,
            @RequestParam("cocktail_glass") String cocktail_glass,
            @RequestParam("cocktail_base") String cocktail_base,
            @RequestParam("cocktail_source") String cocktail_source) {

        String result = "fail";
        try {
            String originalName = cocktail_bitmap_file.getOriginalFilename();
            String filePath = basePath + "/" + originalName;
            String extension = originalName.substring(originalName.length() - 4, originalName.length());

            int i = 1;
            String fileName = filePath;

            while (new File(filePath).exists()) {
                filePath = fileName.substring(0, fileName.length() - 4).concat("(" + i + ")").concat(extension);
                i++;
            }

            File dest = new File(filePath);
            cocktail_bitmap_file.transferTo(dest);

            Map<String, String> map = new HashMap<String, String>();
            map.put("cocktail_name", cocktail_name);
            map.put("cocktail_writer", cocktail_writer);
            map.put("cocktail_image", dest.getName());
            map.put("cocktail_explanation", cocktail_explanation);
            map.put("cocktail_glass", cocktail_glass);
            map.put("cocktail_base", cocktail_base);
            map.put("cocktail_source", cocktail_source);

            mMapper.insertCocktail(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @PostMapping("md")
    public String updateCocktail(
            @RequestParam("cocktail_uuid") String cocktail_uuid,
            @RequestParam("aft_cocktail_bitmap_file") MultipartFile aft_cocktail_bitmap_file,
            @RequestParam("aft_cocktail_name") String aft_cocktail_name,
            @RequestParam("aft_cocktail_writer") String aft_cocktail_writer,
            @RequestParam("aft_cocktail_explanation") String aft_cocktail_explanation,
            @RequestParam("aft_cocktail_glass") String aft_cocktail_glass,
            @RequestParam("aft_cocktail_base") String aft_cocktail_base,
            @RequestParam("aft_cocktail_source") String aft_cocktail_source) {

        String result = "fail";
        try {

            String originalName = aft_cocktail_bitmap_file.getOriginalFilename();
            String filePath = basePath + "/" + originalName;
            String extension = originalName.substring(originalName.length() - 4, originalName.length());

            int i = 1;
            String fileName = filePath;

            while (new File(filePath).exists()) {
                filePath = fileName.substring(0, fileName.length() - 4).concat("(" + i + ")").concat(extension);
                i++;
            }

            File dest = new File(filePath);
            aft_cocktail_bitmap_file.transferTo(dest);

            Map<String, String> map = new HashMap<String, String>();
            map.put("cocktail_uuid", cocktail_uuid);
            map.put("aft_cocktail_name", aft_cocktail_name);
            map.put("aft_cocktail_writer", aft_cocktail_writer);
            map.put("aft_cocktail_image", dest.getName());
            map.put("aft_cocktail_explanation", aft_cocktail_explanation);
            map.put("aft_cocktail_glass", aft_cocktail_glass);
            map.put("aft_cocktail_base", aft_cocktail_base);
            map.put("aft_cocktail_source", aft_cocktail_source);

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
