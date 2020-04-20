package com.ysg.entity;

import lombok.Data;

import java.util.List;

@Data
public class Cart {

    //商家id
    private String sellerId;
    //商家名称
    private String sellerName;
    //购物车明细集合
    private List<TbOrderItem> orderItems;
}
