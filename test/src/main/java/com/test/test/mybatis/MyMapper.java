package com.test.test.mybatis;

import java.util.HashMap;
import java.util.List;

import com.test.test.data;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MyMapper {
    int deleteData(HashMap<Object, Object> vo) throws Exception;

    int updateData(HashMap<Object, Object> vo) throws Exception;

    int insertData(String data) throws Exception;

    List<data> selectData();
}