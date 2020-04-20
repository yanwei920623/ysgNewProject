package com.ysg.serviceimpl;

import com.ysg.mapper.TbUserMapper;
import com.ysg.entity.TbUser;
import com.ysg.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser findUser(String username, String password) {
        return tbUserMapper.selectByNameAndPassword(username,password);
    }

    @Override
    public TbUser findUserByName(String username) {
        return tbUserMapper.selectByName(username);
    }
}
