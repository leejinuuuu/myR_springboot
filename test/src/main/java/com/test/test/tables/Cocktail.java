package com.test.test.tables;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cocktail {
    public String cocktail_uuid;
    public String cocktail_name;
    public String cocktail_writer;
    public String cocktail_image;
    public String cocktail_explanation;
    public String cocktail_glass;
    public String cocktail_base;
    public String cocktail_source;

    // setting
    public ArrayList<Setting> settings;
    // comment
    public ArrayList<Comment> comments;

    Cocktail(
            String cocktail_uuid,
            String cocktail_name,
            String cocktail_writer,
            String cocktail_image,
            String cocktail_explanation,
            String cocktail_glass,
            String cocktail_base,
            String cocktail_source,
            ArrayList<Setting> settings,
            ArrayList<Comment> comments) {
        this.cocktail_uuid = cocktail_uuid;
        this.cocktail_name = cocktail_name;
        this.cocktail_writer = cocktail_writer;
        this.cocktail_image = cocktail_image;
        this.cocktail_explanation = cocktail_explanation;
        this.cocktail_glass = cocktail_glass;
        this.cocktail_base = cocktail_base;
        this.cocktail_source = cocktail_source;

        this.settings = settings;
        this.comments = comments;
    }
}
