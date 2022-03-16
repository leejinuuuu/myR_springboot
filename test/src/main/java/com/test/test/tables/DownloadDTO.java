package com.test.test.tables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DownloadDTO {
    public String downloadUserWithCocktail_uuid;
    public String cocktail_uuid;
    public String cocktail_name;
    public String user_id;
}
