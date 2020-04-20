package com.ysg.controller;

import com.ysg.entity.TestOneModel;
import com.ysg.service.TestOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TestOneController {

    @Autowired
    private TestOne testOne;


    @RequestMapping("testone")
    public List<TestOneModel> findList(){
        return testOne.findAll("0");
    }

}
