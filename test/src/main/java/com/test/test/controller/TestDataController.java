package com.test.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.test.test.data;
import com.test.test.mybatis.MyMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class TestDataController {

    @RequestMapping(value = "/params", method = RequestMethod.GET)
    public data args(
            @RequestParam(value = "param1") String param1,
            @RequestParam(value = "param2", required = false, defaultValue = "param2Default") String param2) {
        System.out.println("param1 : " + param1 + "\nparam2 : " + param2);

        data data = new data();
        data.data0 = param1;
        data.data1 = param2;
        data.data2_ignore = param1;
        // data.data3_null = param2;

        return data;
    }

    @Autowired
    private MyMapper mMapper;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public List<data> getData(HttpServletRequest request) {

        System.out.println(mMapper.selectData());

        return mMapper.selectData();
    }

    // @RequestMapping(value = "/data", method = RequestMethod.POST)
    // public int insertData(
    // @RequestBody data data) {

    // int result = 0;
    // try {
    // result = mMapper.insertData(data);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }

    // return result;
    // }

}