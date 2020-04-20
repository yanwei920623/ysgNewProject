package com.ysg.controller;

import com.ysg.entity.TbItemCat;
import com.ysg.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/ItemCat")
public class TbItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/findItemCats")
    public List<TbItemCat> findItemCats(Long parentId){
        return itemCatService.selectByParentId(parentId);
    }



}
