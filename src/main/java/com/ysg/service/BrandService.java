package com.ysg.service;


import com.ysg.entity.TbBrand;
import com.ysg.utils.PageResult;

import java.util.List;

public interface BrandService {

    //查找单个商品
    public TbBrand findtbBrand(Long id);

    //查找所有商品
    public List<TbBrand> findAll();

    //修改商品
    public int updateOneBrand(TbBrand record);

    /**
     *     分页查询
     * @pageNum 当前页面
     * @pageSize 当前页数
     */
    public PageResult findPage(int pageNum, int pageSize);


}
