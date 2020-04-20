package com.ysg.service;


import com.ysg.entity.TbItemCat;

import java.util.List;

public interface ItemCatService {

    //查询不同级别数据
    List<TbItemCat> selectByParentId(Long parentId);




}
