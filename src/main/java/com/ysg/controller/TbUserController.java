package com.ysg.controller;

import com.ysg.entity.TbUser;
import com.ysg.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    @RequestMapping("/login")
    public TbUser Login(String username, String password){
        System.out.println("TbUserController.Login"+tbUserService.findUser(username, password));
        return tbUserService.findUser(username, password);
    }

}
