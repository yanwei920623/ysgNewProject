package com.ysg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2020/3/14.
 */
@Controller
@RequestMapping("/temp")
public class TempController {

    @GetMapping("/demo1")
    public String index() {return "temples/tempIndex";}
}
