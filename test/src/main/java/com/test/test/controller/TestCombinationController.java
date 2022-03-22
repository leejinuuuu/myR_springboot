package com.test.test.controller;

import java.util.HashMap;
import java.util.Map;

import com.test.test.service.CombinationService;
import com.test.test.tables.CommentDTO;
import com.test.test.tables.DownloadDTO;
import com.test.test.tables.SettingDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("cb")
public class TestCombinationController {

    @Autowired
    private CombinationService combinationService;

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

        return combinationService.insertSetting(map);
    }

    @DeleteMapping("setting")
    public String deleteSetting(
            @RequestBody SettingDTO setting) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("cocktail_uuid", setting.getCocktail_uuid());
        map.put("ingredient_uuid", setting.getIngredient_uuid());

        return combinationService.deleteSetting(map);
    }

    @PostMapping("download/add")
    public String insertDownload(
            @RequestBody DownloadDTO download) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("cocktail_uuid", download.getCocktail_uuid());
        map.put("cocktail_name", download.getCocktail_name());
        map.put("user_id", download.getUser_id());

        return combinationService.insertDownload(map);
    }

    @DeleteMapping("download")
    public String deleteDownload(
            @RequestBody DownloadDTO download) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", download.getUser_id());
        map.put("cocktail_uuid", download.getCocktail_uuid());

        return combinationService.deleteDownload(map);
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
        return combinationService.insertComment(map);

    }

    @DeleteMapping("comment")
    public String deleteComment(
            @RequestBody CommentDTO comment) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", comment.getUser_id());
        map.put("cocktail_uuid", comment.getCocktail_uuid());
        map.put("comment", comment.getComment());
        map.put("time", comment.getTime());
        return combinationService.deleteComment(map);

    }
}
