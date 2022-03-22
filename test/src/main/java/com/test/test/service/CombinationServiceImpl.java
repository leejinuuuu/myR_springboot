package com.test.test.service;

import java.util.Map;

import com.test.test.mybatis.MyMapper;

import org.springframework.beans.factory.annotation.Autowired;

public class CombinationServiceImpl implements CombinationService {

    @Autowired
    private MyMapper mMapper;

    @Override
    public String insertSetting(Map<String, String> map) {
        String result = "fail";
        try {
            mMapper.insertSetting(map);
            result = "succcess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String deleteSetting(Map<String, String> map) {
        String result = "fail";
        try {
            mMapper.deleteSetting(map);
            result = "succcess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String insertDownload(Map<String, String> map) {
        String result = "fail";
        try {
            mMapper.insertDownload(map);
            result = "succcess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String deleteDownload(Map<String, String> map) {
        String result = "fail";
        try {
            mMapper.deleteDownload(map);
            result = "succcess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String insertComment(Map<String, String> map) {
        String result = "fail";
        try {
            mMapper.insertComment(map);
            result = "succcess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String deleteComment(Map<String, String> map) {
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
