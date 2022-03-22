package com.test.test.controller;

import java.util.HashMap;
import java.util.Map;
import com.test.test.mybatis.MyMapper;
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
@RequestMapping("us")
public class TestUserController {

    @Autowired
    private MyMapper mMapper;

    @GetMapping("check")
    public String checkUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user.getUser_id());

        String result = "fail";
        try {
            mMapper.checkUser(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("login")
    public UserDTO loginUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user.getUser_id());
        map.put("user_password", user.getUser_password());

        UserDTO result = null;
        try {
            result = mMapper.loginUser(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("signup")
    public String insertUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user.getUser_id());
        map.put("user_password", user.getUser_password());
        map.put("user_nickname", user.getUser_nickname());
        map.put("user_email", user.getUser_email());

        String result = "fail";
        try {
            mMapper.insertUser(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("search")
    public UserDTO searchUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_email", user.getUser_email());

        UserDTO result = null;
        try {

            result = mMapper.searchUser(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("md")
    public String modifyUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_nickname", user.getUser_nickname());
        map.put("user_id", user.getUser_id());
        map.put("user_password", user.getUser_password());
        map.put("user_email", user.getUser_email());

        String result = "fail";
        try {
            mMapper.modifyUser(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("")
    public UserDTO detailUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user.getUser_id());

        UserDTO result = null;
        try {
            result = mMapper.detailUser(map);
            result.setDownload(mMapper.detailUser_download(map));
            result.setComment(mMapper.detailUser_comment(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @DeleteMapping("")
    public String deleteUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user.getUser_id());

        String result = "fail";
        try {
            mMapper.deleteUser(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
