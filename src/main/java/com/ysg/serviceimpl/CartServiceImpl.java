package com.ysg.serviceimpl;

import com.ysg.mapper.TbItemMapper;
import com.ysg.entity.Cart;
import com.ysg.entity.TbItem;
import com.ysg.entity.TbOrderItem;
import com.ysg.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Cart> addCartList(List<Cart> list, Long itemId, Integer num) {
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
        if(tbItem == null){
            throw  new RuntimeException("商品不存在");
        }
        if(!tbItem.getStatus().equals("1")){
            throw  new RuntimeException("商品状态不合法");
        }
        //商家id
        String sellerId = tbItem.getSellerId();
        Cart cart = searchCart(list, sellerId);
        //如果购物车明细对象为空
        if(cart == null){
            //创建一个新的购物车明细对象
            cart = new Cart();
            cart.setSellerId(sellerId);
            cart.setSellerName(tbItem.getSeller());
            //创建购物车明细列表
            List<TbOrderItem> tbOrderItems = new ArrayList<>();
            TbOrderItem orderItem = createOrderItem(tbItem, num);
            tbOrderItems.add(orderItem);
            cart.setOrderItems(tbOrderItems);
            //将新的购物车对象添加到购物车列表中
            list.add(cart);
        }else {
            //判断该商品是否在该购物车列表中
            TbOrderItem tbOrderItem = null;
            for (TbOrderItem orderItem:cart.getOrderItems()) {
                if(orderItem.getItemId().longValue()==itemId.longValue()){
                    tbOrderItem = orderItem;
                }
            }
            //如果不存在
            if(tbOrderItem == null){
                tbOrderItem = createOrderItem(tbItem, num);
                cart.getOrderItems().add(tbOrderItem);
            }else{
                tbOrderItem.setNum(tbOrderItem.getNum()+num);
                //设置金额
                tbOrderItem.setTotalFee(new BigDecimal(tbOrderItem.getPrice().doubleValue()*tbOrderItem.getNum()));
                //当明细的数量下小于等于0
                if (tbOrderItem.getNum()<=0){
                    cart.getOrderItems().remove(tbOrderItem);
                }
                //当购物车的明细列表为0时，删掉此购物车
                if (cart.getOrderItems().size()<=0){
                    list.remove(cart);
                }
            }

        }

        return list;
    }

    @Override
    public List<Cart> findCartListRedis(String username) {
        System.out.println("向redis中取出购物车"+username);
        List<Cart> cartList = (List<Cart>)redisTemplate.boundHashOps("cartList").get(username);
        if(cartList==null){
            cartList = new ArrayList<>();
        }
        return cartList;
    }

    @Override
    public void saveCartListRedis(String username, List<Cart> cartList) {
        System.out.println("向redis中存入购物车"+username);
        redisTemplate.boundHashOps("cartList").put(username,cartList);

    }

    @Override
    public List<Cart> mergeCartList(List<Cart> list1, List<Cart> list2) {
        list2.removeAll(list1);
        list1.addAll(list2);
        return list1;
    }

    public Cart searchCart(List<Cart> list,String sellerId){

        for (Cart cart:list){
            if(cart.getSellerId().equals(sellerId)){
                    return cart;
            }
        }

        return null;
    }


    public TbOrderItem createOrderItem(TbItem tbItem,Integer num){

        TbOrderItem tbOrderItem = new TbOrderItem();
        tbOrderItem.setGoodsId(tbItem.getGoodsId());
        tbOrderItem.setItemId(tbItem.getId());
        tbOrderItem.setNum(num);
        tbOrderItem.setPicPath(tbItem.getImage());
        tbOrderItem.setPrice(new BigDecimal(tbItem.getPrice()));
        tbOrderItem.setSellerId(tbItem.getSellerId());
        tbOrderItem.setTitle(tbItem.getTitle());
        tbOrderItem.setTotalFee(new BigDecimal(tbItem.getPrice().doubleValue()*num));

        return tbOrderItem;
    }

}
