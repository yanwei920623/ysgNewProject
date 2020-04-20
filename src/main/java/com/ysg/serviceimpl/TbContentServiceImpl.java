package com.ysg.serviceimpl;

import com.ysg.mapper.TbContentMapper;
import com.ysg.entity.TbContent;
import com.ysg.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> selectByCategoryId(Long categoryId) {
        List<TbContent> list = (List<TbContent>) redisTemplate.opsForHash().get("hashValue",categoryId);
        if(list == null){
            list = tbContentMapper.findByCategoryId(categoryId);
            redisTemplate.opsForHash().put("hashValue",categoryId,list);
        }
        return list;
    }
}
