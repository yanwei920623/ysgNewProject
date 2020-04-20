package com.ysg.serviceimpl;

import com.ysg.mapper.TbItemCatMapper;
import com.ysg.entity.TbItemCat;
import com.ysg.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> selectByParentId(Long parentId){
        return tbItemCatMapper.selectByParentId(parentId);
    }
}
