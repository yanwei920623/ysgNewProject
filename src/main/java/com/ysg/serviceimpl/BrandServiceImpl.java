package com.ysg.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ysg.mapper.TbBrandMapper;
import com.ysg.entity.TbBrand;
import com.ysg.service.BrandService;
import com.ysg.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public TbBrand findtbBrand(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public int updateOneBrand(TbBrand record) {
        return tbBrandMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbBrand> page= (Page<TbBrand>)tbBrandMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }


}
