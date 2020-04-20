package com.ysg.service;


import com.ysg.entity.User;

import java.util.List;
import java.util.Map;

public interface  UserService {

    //添加用户
    int addUser(User user);

    //查询用户
    User user(int id);

    //动态查询
    List<User> userList(Map<String, String> map);
}
