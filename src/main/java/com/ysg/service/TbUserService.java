package com.ysg.service;


import com.ysg.entity.TbUser;

public interface TbUserService {

    //查找用户
    public TbUser findUser(String username, String password);

    //查找用户
    public TbUser findUserByName(String username);


}
