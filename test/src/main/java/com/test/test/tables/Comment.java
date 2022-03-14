package com.test.test.tables;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    public String commentCocktailWithUser_uuid;
    public String cocktail_uuid;
    public String cocktail_name;
    public String user_id;
    public String comment;
    public String time;

    Comment(
            String commentCocktailWithUser_uuid,
            String cocktail_uuid,
            String cocktail_name,
            String user_id,
            String comment,
            String time) {
        this.commentCocktailWithUser_uuid = commentCocktailWithUser_uuid;
        this.cocktail_uuid = cocktail_uuid;
        this.cocktail_name = cocktail_name;
        this.user_id = user_id;
        this.comment = comment;
        this.time = time;
    }
}
