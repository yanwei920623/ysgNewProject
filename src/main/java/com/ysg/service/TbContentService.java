package com.ysg.service;


import com.ysg.entity.TbContent;

import java.util.List;


public interface TbContentService {

    //查询不同级别数据
    public List<TbContent> selectByCategoryId(Long categoryId);

}
