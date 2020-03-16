package com.ysg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2020/3/14.
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {return "index";}
}
