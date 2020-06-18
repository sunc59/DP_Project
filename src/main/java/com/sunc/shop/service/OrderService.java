package com.sunc.shop.service;


import com.sunc.shop.dao.OrderDao;
import com.sunc.shop.dao.OrderItemDao;
import com.sunc.shop.model.Order;
import com.sunc.shop.model.OrderItem;

import java.util.List;

/**
 * @auther sunc
 * @date 2020/4/21 9:24
 */
public class OrderService {

    private OrderDao orderDao = new OrderDao();

    public int addgetOrder(Order order) {
        int i = orderDao.insertGetId(order);
        return i;
    }

    /**
     *  根据OrderId查询Order的详细信息
     */
    public Order findOrderByOrderId(String oid) {
        Order order = orderDao.findOrderByOrderId(oid);
        OrderItemDao orderItemDao = new OrderItemDao();
        List<OrderItem> list = orderItemDao.findOrderItemByOrderId(oid);
        order.setList(list);
        return order;
    }

    public void confirmPayOrder(String oid) {
        orderDao.confirmPayOrder(oid);
    }

    /**
     *  获得当前用户的所有订单
     */
    public List<Order> findAllOrderByUserId(int uid) {
        List<Order> list = orderDao.findAllOrderByUserId(uid);
        for (Order order : list) {
            OrderItemDao orderItemDao = new OrderItemDao();
            List<OrderItem> items = orderItemDao.findOrderItemByOrderId(order.getId()+"");
            order.setList(items);
        }
        return list;
    }

    public void getStatus(String oid) {
        orderDao.getStatus(oid);
    }

    public void reviewStatus(String oid) {
        orderDao.reviewStatus(oid);
    }

    /**
     *  查询所有订单
     *  前后台都需要的功能
     */
    public List<Order> findAllOrders() {
        List<Order> list = orderDao.findAllOrders();
        for (Order order : list) {
            OrderItemDao orderItemDao = new OrderItemDao();
            List<OrderItem> items = orderItemDao.findOrderItemByOrderId(order.getId()+"");
            order.setList(items);
        }
        return list;
    }

    /**
     *  后台功能，修改订单状态为已发货
     * @param oid
     */
    public void faHuo(String oid) {
        orderDao.faHuoStatus(oid);
    }
}
