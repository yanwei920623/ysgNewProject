package com.ysg.entity;

import lombok.Data;

import java.util.List;


@Data
public class TestOneModel {

    private String id;

    private String name;

    private String pid;

    private List<Testone> childlist;



}
