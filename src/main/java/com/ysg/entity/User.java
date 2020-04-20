package com.ysg.entity;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {

    private Integer id;
    private String username;
    private String password;
    private String phone;
    private Date created;
    private Date updated;

//    public User(){
//        super();
//    }
//
//    public User(String city, String address, String brandName, String payment, String province) {
//        super();
//        this.city = city;
//        this.address = address;
//        this.brandName = brandName;
//        this.payment = payment;
//        this.province = province;
//    }
//
//    //City表的city字段
//    private String city;
//    //Address表address字段
//    private String address;
//    //Brand表name字段
//    private String brandName;
//    //Oreder表payment字段
//    private String payment;
//    //Province表province字段
//    private String province;


}
