package com.ysg.serviceimpl;

import com.ysg.mapper.TestoneMapper;
import com.ysg.entity.TestOneModel;
import com.ysg.service.TestOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestOneServiceImpl implements TestOne {

    @Autowired
    private TestoneMapper testoneMapper;

    @Override
    public List<TestOneModel> findAll(String pid) {
        return testoneMapper.findList(pid);
    }
}
