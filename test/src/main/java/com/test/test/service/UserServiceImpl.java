package com.test.test.service;

import java.util.Map;

import com.test.test.mybatis.MyMapper;
import com.test.test.tables.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MyMapper mMapper;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String checkUser(Map<String, String> map) {
        String result = "fail";
        try {
            mMapper.checkUser(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public UserDTO loginUser(Map<String, String> map) {
        UserDTO result = null;
        try {
            result = mMapper.loginUser(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String insertUser(Map<String, String> map) {
        String result = "fail";
        try {
            String encodePassword = passwordEncoder.encode(map.get("user_password"));
            map.put("user_password", encodePassword);

            mMapper.insertUser(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public UserDTO searchUser(Map<String, String> map) {
        UserDTO result = null;
        try {
            result = mMapper.searchUser(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String modifyUser(Map<String, String> map) {
        String result = "fail";
        try {
            mMapper.modifyUser(map);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public UserDTO detailUser(Map<String, String> map) {
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

    @Override
    public String deleteUser(Map<String, String> map) {
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
