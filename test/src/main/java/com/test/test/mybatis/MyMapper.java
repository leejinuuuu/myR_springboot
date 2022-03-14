package com.test.test.mybatis;

import java.util.HashMap;
import java.util.List;

import com.test.test.data;
import com.test.test.tables.Cocktail;
import com.test.test.tables.Ingredient;
import com.test.test.tables.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MyMapper {
    int deleteData(HashMap<Object, Object> vo) throws Exception;

    int updateData(HashMap<Object, Object> vo) throws Exception;

    int insertData(data data) throws Exception;

    List<data> selectData();

    // 재료
    List<Ingredient> listIngredient(@Param("start") String start, @Param("end") String end);

    String insertIngredient(@Param("ingredient_name") String ingredient_name,
            @Param("ingredient_image") String ingredient_image);

    Ingredient detailIngredient(@Param("ingredient_uuid") String ingredient_uuid);

    String deleteIngredient(@Param("ingredient_uuid") String ingredient_uuid);

    // 칵테일
    List<Cocktail> listCocktail(@Param("start") String start, @Param("end") String end);

    List<Cocktail> listStdCocktail(@Param("show_std") String show_std,
            @Param("show_std_content") String show_std_content, @Param("start") String start, @Param("end") String end);

    String insertCocktail(
            @Param("cocktail_name") String cocktail_name,
            @Param("cocktail_writer") String cocktail_writer,
            @Param("cocktail_image") String cocktail_image,
            @Param("cocktail_explanation") String cocktail_explanation,
            @Param("cocktail_glass") String cocktail_glass,
            @Param("cocktail_base") String cocktail_base,
            @Param("cocktail_source") String cocktail_source);

    String updateCocktail(
            @Param("aft_cocktail_name") String aft_cocktail_name,
            @Param("aft_cocktail_writer") String aft_cocktail_writer,
            @Param("aft_cocktail_image") String aft_cocktail_image,
            @Param("aft_cocktail_explanation") String aft_cocktail_explanation,
            @Param("aft_cocktail_glass") String aft_cocktail_glass,
            @Param("aft_cocktail_base") String aft_cocktail_base,
            @Param("aft_cocktail_source") String aft_cocktail_source,
            @Param("cocktail_uuid") String cocktail_uuid);

    Cocktail detailCocktail(@Param("cocktail_uuid") String cocktail_uuid);

    String existCocktail(@Param("cocktail_uuid") String cocktail_uuid);

    String deleteCocktail(@Param("cocktail_uuid") String cocktail_uuid);

    // 사용자
    String loginUser(@Param("user_id") String user_id, @Param("user_password") String user_password);

    String insertUser(
            @Param("user_id") String user_id,
            @Param("user_password") String user_password,
            @Param("user_nickname") String user_nickname,
            @Param("user_email") String user_email);

    User searchUser(@Param("user_email") String user_email);

    String modifyUser(@Param("user_nickname") String user_nickname);

    User detailUser(@Param("user_id") String user_id);

    String deleteUser(@Param("user_id") String user_id);

    // 조합-칵테일-재료
    String insertSetting(
            @Param("cocktail_uuid") String cocktail_uuid,
            @Param("cocktail_name") String cocktail_name,
            @Param("ingredient_uuid") String ingredient_uuid,
            @Param("ingredient_name") String ingredient_name,
            @Param("vol") String vol,
            @Param("tool") String tool);

    String deleteSetting(@Param("cocktail_uuid") String cocktail_uuid,
            @Param("ingredient_uuid") String ingredient_uuid);

    // 다운로드-칵테일-사용자
    String insertDownload(
            @Param("cocktail_uuid") String cocktail_uuid,
            @Param("cocktail_name") String cocktail_name,
            @Param("user_id") String user_id);

    String deleteDownload(@Param("user_id") String user_id, @Param("cocktail_uuid") String cocktail_uuid);

    // 댓글-칵테일-사용자
    String insertComment(
            @Param("cocktail_uuid") String cocktail_uuid,
            @Param("cocktail_name") String cocktail_name,
            @Param("user_id") String user_id,
            @Param("comment") String comment,
            @Param("time") String time);

    String deleteComment(
            @Param("user_id") String user_id,
            @Param("cocktail_uuid") String cocktail_uuid,
            @Param("comment") String comment,
            @Param("time") String time);
}