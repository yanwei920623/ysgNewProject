package com.ysg.serviceimpl;


import com.ysg.mapper.TbItemMapper;
import com.ysg.entity.TbItem;
import com.ysg.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbItemServiceImpl implements TbItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public List<TbItem> findAllItem(String status) {
        return tbItemMapper.findAllItem(status);
    }
}
