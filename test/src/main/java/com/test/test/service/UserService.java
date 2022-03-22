package com.test.test.service;

import java.util.Map;

import com.test.test.tables.UserDTO;

public interface UserService {
    public String checkUser(Map<String, String> map);

    public UserDTO loginUser(Map<String, String> map);

    public String insertUser(Map<String, String> map);

    public UserDTO searchUser(Map<String, String> map);

    public String modifyUser(Map<String, String> map);

    public UserDTO detailUser(Map<String, String> map);

    public String deleteUser(Map<String, String> map);
}