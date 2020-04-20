package com.ysg.service;


import com.ysg.entity.Cart;

import java.util.List;

public interface CartService {

    List<Cart> addCartList(List<Cart> list, Long itemId, Integer num);


    List<Cart> findCartListRedis(String username);

    void saveCartListRedis(String username, List<Cart> cartList);

    List<Cart> mergeCartList(List<Cart> list1, List<Cart> list2);

}
