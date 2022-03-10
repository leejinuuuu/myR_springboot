package com.test.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// null 값을 가지는 변수는 return하지 않음
@JsonInclude(JsonInclude.Include.NON_NULL)
public class data {
    public String data0;
    public String data1;

    // 아예 return하지 않음
    @JsonIgnore
    public String data2_ignore;

    public String data3_null = null;
}
