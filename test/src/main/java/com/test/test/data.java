package com.test.test;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class data {
    public String data0 = null;
    public String data1 = null;

    // 아예 return하지 않음
    @JsonIgnore
    public String data2_ignore;

    public String data3_null = null;
}
