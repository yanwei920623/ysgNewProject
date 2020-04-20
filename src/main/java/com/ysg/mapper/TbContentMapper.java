package com.ysg.mapper;

import com.ysg.entity.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TbContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    TbContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKey(TbContent record);

    List<TbContent> findByCategoryId(Long categoryId);
}