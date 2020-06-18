package com.sunc.shop.service;


import com.sunc.shop.dao.OrderItemDao;
import com.sunc.shop.model.OrderItem;

/**
 * @auther sunc
 * @date 2020/4/21 13:48
 */
public class OrderItemService {

    private OrderItemDao orderItemDao = new OrderItemDao();

    public void addOrderItem(OrderItem orderItem) {
        orderItemDao.insertOrderItem(orderItem);
    }


}
