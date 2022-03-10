package com.test.test.controller;

import javax.servlet.http.HttpServletRequest;

import com.test.test.data;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {
        System.out.println("home");

        return "content/home";
    }

    @GetMapping("/params")
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
}