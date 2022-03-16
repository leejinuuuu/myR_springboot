package com.test.test.tables;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CocktailDTO {
    public String cocktail_uuid;
    public String cocktail_name;
    public String cocktail_writer;
    public String cocktail_image;
    public String cocktail_explanation;
    public String cocktail_glass;
    public String cocktail_base;
    public String cocktail_source;

    // setting
    public ArrayList<SettingDTO> settings;
    // comment
    public ArrayList<CommentDTO> comments;
}
