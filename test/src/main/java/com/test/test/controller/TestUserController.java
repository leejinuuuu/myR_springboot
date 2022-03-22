package com.test.test.controller;

import java.util.HashMap;
import java.util.Map;
import com.test.test.service.UserService;
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
    private UserService userService;

    @GetMapping("check")
    public String checkUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user.getUser_id());

        return userService.checkUser(map);
    }

    @GetMapping("login")
    public UserDTO loginUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user.getUser_id());
        map.put("user_password", user.getUser_password());

        return userService.loginUser(map);
    }

    @PostMapping("signup")
    public String insertUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user.getUser_id());
        map.put("user_password", user.getUser_password());
        map.put("user_nickname", user.getUser_nickname());
        map.put("user_email", user.getUser_email());

        return userService.insertUser(map);
    }

    @GetMapping("search")
    public UserDTO searchUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_email", user.getUser_email());

        return userService.searchUser(map);
    }

    @PostMapping("md")
    public String modifyUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_nickname", user.getUser_nickname());
        map.put("user_id", user.getUser_id());
        map.put("user_password", user.getUser_password());
        map.put("user_email", user.getUser_email());

        return userService.modifyUser(map);
    }

    @GetMapping("")
    public UserDTO detailUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user.getUser_id());

        return userService.detailUser(map);
    }

    @DeleteMapping("")
    public String deleteUser(
            @RequestBody UserDTO user) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user.getUser_id());

        return userService.deleteUser(map);
    }
}
