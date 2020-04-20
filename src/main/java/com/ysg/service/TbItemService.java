package com.ysg.service;


import com.ysg.entity.TbItem;

import java.util.List;

public interface TbItemService {

    List<TbItem> findAllItem(String status);



}
