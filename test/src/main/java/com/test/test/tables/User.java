package com.test.test.tables;

import java.util.ArrayList;

public class User {
    public String user_id;
    public String user_password;
    public String user_nickname;
    public String user_email;

    public ArrayList<String> cocktail_name;

    User(
            String user_id,
            String user_password,
            String user_nickname,
            String user_email,
            ArrayList<String> cocktail_name) {
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_nickname = user_nickname;
        this.user_email = user_email;
        this.cocktail_name = cocktail_name;
    }
}