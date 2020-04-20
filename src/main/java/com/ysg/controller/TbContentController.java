package com.ysg.controller;


import com.ysg.entity.TbContent;
import com.ysg.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("content")
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;

    @RequestMapping("findByCategoryId")
    public List<TbContent> findByCategoryId(Long categoryId){
        return tbContentService.selectByCategoryId(categoryId);
    }

}
