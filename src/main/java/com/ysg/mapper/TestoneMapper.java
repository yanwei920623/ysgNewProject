package com.ysg.mapper;

import com.ysg.entity.TestOneModel;
import com.ysg.entity.Testone;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TestoneMapper {
    int deleteByPrimaryKey(String id);

    int insert(Testone record);

    int insertSelective(Testone record);

    Testone selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Testone record);

    int updateByPrimaryKey(Testone record);

    List<TestOneModel> findList(String pid);
}