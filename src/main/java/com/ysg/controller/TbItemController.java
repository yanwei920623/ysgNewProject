package com.ysg.controller;

import com.alibaba.fastjson.JSON;
import com.ysg.entity.TbItem;
import com.ysg.service.TbItemService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("item")
public class TbItemController {

    @Autowired
    private TbItemService tbItemService;

    @Autowired
    private SolrClient solrClient;

    @RequestMapping("addtest")
    public String addtest(String status){
        try {
            List<TbItem> list =tbItemService.findAllItem(status);
            for (TbItem tb:list) {
                Map<String,String> map =JSON.parseObject(tb.getSpec(), Map.class);
                tb.setSpecMap(map);
//                System.out.println("TbItemController.addtest"+tb);
            }
            solrClient.addBeans(list);
            return "successs";
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return "faied";
    }
}
