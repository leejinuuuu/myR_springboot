package com.test.test.tables;

public class Download {
    public String downloadUserWithCocktail_uuid;
    public String cocktail_uuid;
    public String cocktail_name;
    public String user_id;

    Download(
            String downloadUserWithCocktail_uuid,
            String cocktail_uuid,
            String cocktail_name,
            String user_id) {
        this.downloadUserWithCocktail_uuid = downloadUserWithCocktail_uuid;
        this.cocktail_uuid = cocktail_uuid;
        this.cocktail_name = cocktail_name;
        this.user_id = user_id;
    }
}
