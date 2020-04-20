package com.ysg.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class PageResult implements Serializable {

    //当前记录总数
    private Long total;
    //当前页记录
    private List rows;



}
