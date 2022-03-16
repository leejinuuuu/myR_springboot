package com.test.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.test.test.data;
import com.test.test.mybatis.MyMapper;
import com.test.test.tables.CommentDTO;
import com.test.test.tables.DownloadDTO;
import com.test.test.tables.SettingDTO;
import com.test.test.tables.UserDTO;

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
@RequestMapping("cb")
public class TestCombinationController {

    @Autowired
    private MyMapper mMapper;

    @PostMapping("setting/add")
    public String insertSetting(
            @RequestBody SettingDTO setting) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("cocktail_uuid", setting.getCocktail_uuid());
        map.put("cocktail_name", setting.getCocktail_name());
        map.put("ingredient_uuid", setting.getIngredient_uuid());
        map.put("ingredient_name", setting.getIngredient_name());
        map.put("vol", setting.getVol());
        map.put("tool", setting.getTool());

        String result = "fail";
        try {
            mMapper.insertSetting(map);
            result = "succcess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @DeleteMapping("setting")
    public String deleteSetting(
            @RequestBody SettingDTO setting) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("cocktail_uuid", setting.getCocktail_uuid());
        map.put("ingredient_uuid", setting.getIngredient_uuid());

        String result = "fail";
        try {
            mMapper.deleteSetting(map);
            result = "succcess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("download/add")
    public String insertDownload(
            @RequestBody DownloadDTO download) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("cocktail_uuid", download.getCocktail_uuid());
        map.put("cocktail_name", download.getCocktail_name());
        map.put("user_id", download.getUser_id());

        String result = "fail";
        try {
            mMapper.insertDownload(map);
            result = "succcess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @DeleteMapping("download")
    public String deleteDownload(
            @RequestBody DownloadDTO download) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", download.getUser_id());
        map.put("cocktail_uuid", download.getCocktail_uuid());

        String result = "fail";
        try {
            mMapper.deleteDownload(map);
            result = "succcess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("comment/add")
    public String insertComment(
            @RequestBody CommentDTO comment) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("cocktail_uuid", comment.getCocktail_uuid());
        map.put("cocktail_name", comment.getCocktail_name());
        map.put("user_id", comment.getUser_id());
        map.put("comment", comment.getComment());
        map.put("time", comment.getTime());

        String result = "fail";
        try {
            mMapper.insertComment(map);
            result = "succcess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @DeleteMapping("comment")
    public String deleteComment(
            @RequestBody CommentDTO comment) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", comment.getUser_id());
        map.put("cocktail_uuid", comment.getCocktail_uuid());
        map.put("comment", comment.getComment());
        map.put("time", comment.getTime());

        String result = "fail";
        try {
            mMapper.deleteComment(map);
            result = "succcess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
