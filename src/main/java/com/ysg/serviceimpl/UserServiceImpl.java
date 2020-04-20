package com.ysg.serviceimpl;

import com.ysg.mapper.UserMapper;
import com.ysg.entity.User;
import com.ysg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User user(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> userList(Map<String,String> map) {
        return userMapper.listUser(map);
    }
}
