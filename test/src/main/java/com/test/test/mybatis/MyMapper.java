package com.test.test.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.test.data;
import com.test.test.tables.CocktailDTO;
import com.test.test.tables.CommentDTO;
import com.test.test.tables.DownloadDTO;
import com.test.test.tables.IngredientDTO;
import com.test.test.tables.SettingDTO;
import com.test.test.tables.UserDTO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MyMapper {
        int deleteData(HashMap<Object, Object> vo) throws Exception;

        int updateData(HashMap<Object, Object> vo) throws Exception;

        void insertData(Map<String, String> vo) throws Exception;

        List<data> selectData();

        // 재료

        // start, end
        ArrayList<IngredientDTO> listIngredient(Map<String, String> map);

        // ingredient_name, ingredient_image
        void insertIngredient(Map<String, String> map);

        // aft_ingredient_name, aft_ingredient_image, ingredient_uuid
        void updateIngredient(Map<String, String> map);

        // ingredient_uuid
        IngredientDTO detailIngredient(Map<String, String> map);

        // ingredient_uuid
        void deleteIngredient(Map<String, String> map);

        // 칵테일

        // start, end
        ArrayList<CocktailDTO> listCocktail(Map<String, String> map);

        // show_std, show_std_content, start, end
        ArrayList<CocktailDTO> listStdCocktail(Map<String, String> map);

        // cocktail_name, cocktail_writer,cocktail_image, cocktail_explanation,
        // cocktail_glass, cocktail_base, cocktail_source
        void insertCocktail(Map<String, String> map);

        // aft_cocktail_name, aft_cocktail_writer, aft_cocktail_image,
        // aft_cocktail_explanation, aft_cocktail_glass, aft_cocktail_base,
        // aft_cocktail_source, cocktail_uuid
        void updateCocktail(Map<String, String> map);

        // cocktail_uuid
        CocktailDTO detailCocktail(Map<String, String> map);

        ArrayList<SettingDTO> detailCocktail_setting(Map<String, String> map);

        ArrayList<CommentDTO> detailCocktail_comment(Map<String, String> map);

        // cocktail_uuid
        void deleteCocktail(Map<String, String> map);

        // 사용자

        // user_id
        UserDTO checkUser(Map<String, String> map);

        // user_id, user_password
        UserDTO loginUser(Map<String, String> map);

        // user_id, user_password, user_nickname, user_email
        void insertUser(Map<String, String> map);

        // user_email
        UserDTO searchUser(Map<String, String> map);

        // user_nickname, user_id, user_password, user_email
        void modifyUser(Map<String, String> map);

        // user_id
        UserDTO detailUser(Map<String, String> map);

        ArrayList<DownloadDTO> detailUser_download(Map<String, String> map);

        ArrayList<CommentDTO> detailUser_comment(Map<String, String> map);

        // user_id
        void deleteUser(Map<String, String> map);

        // 조합-칵테일-재료

        // cocktail_uuid, cocktail_name, ingredient_uuid, ingredient_name, vol, tool
        void insertSetting(Map<String, String> map);

        // cocktail_uuid, ingredient_uuid
        void deleteSetting(Map<String, String> map);

        // 다운로드-칵테일-사용자

        // cocktail_uuid, cocktail_name, user_id
        void insertDownload(Map<String, String> map);

        // user_id, cocktail_uuid
        void deleteDownload(Map<String, String> map);

        // 댓글-칵테일-사용자

        // cocktail_uuid, cocktail_name, user_id, comment, time
        void insertComment(Map<String, String> map);

        // user_id, cocktail_uuid, comment, time
        void deleteComment(Map<String, String> map);
}