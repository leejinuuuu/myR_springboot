package com.test.test.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.test.test.Global;
import com.test.test.mybatis.MyMapper;
import com.test.test.tables.IngredientDTO;

import org.springframework.beans.factory.annotation.Autowired;

public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private MyMapper mMapper;

    @Override
    public List<IngredientDTO> listIngredient(Map<String, String> map) {
        List<IngredientDTO> result = null;
        try {
            result = mMapper.listIngredient(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public String insertIngredient(Map<String, String> map) {
        String result = "fail";
        try {
            mMapper.insertIngredient(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateIngredient(Map<String, String> map) {
        String result = "fail";
        try {
            mMapper.updateIngredient(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public IngredientDTO detailIngredient(Map<String, String> map) {
        IngredientDTO result = null;
        try {
            result = mMapper.detailIngredient(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String deleteIngredient(Map<String, String> map) {

        String result = "fail";
        try {
            File file = new File(Global.basePath + mMapper.detailIngredient(map).ingredient_image);

            if (file.exists()) {
                if (file.delete()) {

                    mMapper.deleteIngredient(map);
                    System.out.println("파일삭제 성공");
                } else
                    System.out.println("파일삭제 실패");
            } else
                System.out.println("파일이 존재하지 않습니다.");

            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
