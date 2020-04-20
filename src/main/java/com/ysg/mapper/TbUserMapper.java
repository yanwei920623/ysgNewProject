package com.ysg.mapper;

import com.ysg.entity.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long id);

    TbUser selectByNameAndPassword(String username, String password);

    TbUser selectByName(String username);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}