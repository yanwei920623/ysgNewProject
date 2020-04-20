package com.ysg.controller;


import com.ysg.entity.User;
import com.ysg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser")
    public User getUser(int id){
        System.out.println("id = [" + id + "]");
        return userService.user(id);
    }

    @RequestMapping(value = "/addUser",method = {POST})
    public int addUser(User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/getListUser")
    public List<User> getListUser(@RequestBody Map<String,String> map){
       // System.out.println("list = [" + userService.userList(list) + "]");
        return userService.userList(map);
    }
}
