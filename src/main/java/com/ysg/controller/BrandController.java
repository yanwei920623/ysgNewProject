package com.ysg.controller;

import com.ysg.entity.TbBrand;
import com.ysg.service.BrandService;
import com.ysg.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/findOneBrand")
    public TbBrand findOneBrand(Long id){
        return brandService.findtbBrand(id);
    }

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    @RequestMapping("/updateOneBrand")
    public int updateOneBrand(@RequestBody TbBrand tbBrand){
        System.out.println("tbBrand11"+tbBrand);
        return brandService.updateOneBrand(tbBrand);
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int size){
        return brandService.findPage(page,size);
    }

}
