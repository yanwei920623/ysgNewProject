package com.ysg.service;


import com.ysg.entity.TestOneModel;

import java.util.List;

public interface TestOne {


    //查找所有商品
    public List<TestOneModel> findAll(String pid);
}
