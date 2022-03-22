package com.test.test.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.test.test.Global;
import com.test.test.mybatis.MyMapper;
import com.test.test.tables.CocktailDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocktailServiceImpl implements CocktailService {

    @Autowired
    private MyMapper mMapper;

    @Override
    public List<CocktailDTO> listCocktail(Map<String, String> map) {
        List<CocktailDTO> result = null;
        try {
            result = mMapper.listCocktail(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<CocktailDTO> listStdCocktail(Map<String, String> map) {
        List<CocktailDTO> result = null;
        try {
            result = mMapper.listStdCocktail(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String insertCocktail(Map<String, String> map) {
        String result = "fail";
        try {
            mMapper.insertCocktail(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateCocktail(Map<String, String> map) {
        String result = "fail";
        try {
            mMapper.updateCocktail(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public CocktailDTO detailCocktail(Map<String, String> map) {
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

    @Override
    public String deleteCocktail(Map<String, String> map) {
        String result = "fail";
        try {
            File file = new File(Global.basePath + mMapper.detailCocktail(map).cocktail_image);

            if (file.exists()) {
                if (file.delete()) {

                    mMapper.deleteCocktail(map);
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
