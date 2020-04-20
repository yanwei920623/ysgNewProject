package com.ysg.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TbBrand implements Serializable {
    private Long id;

    private String name;

    private String firstChar;
}