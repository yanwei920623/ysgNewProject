package com.ysg.controller;


import com.alibaba.fastjson.JSON;
import com.ysg.entity.Cart;
import com.ysg.entity.Result;
import com.ysg.service.CartService;
import com.ysg.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/findCartList")
    public List<Cart> findCartList(){
        //当前登录人名称
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        String cartList = CookieUtils.getCookie("cartList");

        if(cartList == null ||cartList.equals(" ")){
            cartList = "[]";
        }
        List<Cart> carts= JSON.parseArray(cartList,Cart.class);
        if(name == null){
            System.out.println("CartController.findCartList.name"+name);
            return carts;
        }else {
            List<Cart> cartListRedis = cartService.findCartListRedis(name);
            if(cartListRedis.size()>0){
                List<Cart> carts1 = cartService.mergeCartList(carts, cartListRedis);
                cartService.saveCartListRedis(name,carts1);
                CookieUtils.removeCookie("cartList");
                return carts1;
            }
           return cartListRedis;
        }


    }

    @RequestMapping("/addCartList")
    @CrossOrigin(origins = "http://localhost:8090",allowCredentials = "true")//跨域
    public Result addCartList(Long itemId, Integer num){
//当前登录人名称
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("CartController.findCartList.name"+name);
        try {
            //从cookie中提取购物车
            List<Cart> cartList = findCartList();
            //调用servcie方法操作购物车
            List<Cart> carts = cartService.addCartList(cartList, itemId, num);
            if(name == null) {
                //将新的购物车加入cookie
                CookieUtils.addCookie("cartList",carts);
            }else {
                cartService.saveCartListRedis(name,carts);
            }
            return new Result(true,"存入成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"存入失败");
        }
    }


}
