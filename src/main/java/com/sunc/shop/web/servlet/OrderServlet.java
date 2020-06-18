package com.sunc.shop.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.*;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.OrderItemService;
import com.sunc.shop.service.OrderService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @auther sunc
 * @date 2020/6/11 22:12
 */
@WebServlet("/order/*")
public class OrderServlet extends BaseServlet {

    private OrderService service = new OrderService();

    /**
     *  通过购物车中的数据生成一个新的订单
     *  包括地址，订单项等
     *  生成了这个订单，之后就坐等支付了
     */
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String aid = request.getParameter("aid");
        String money = request.getParameter("money");

        /**
         *  生成订单...
         */
        Order order = new Order();
        AddressService addressService = new AddressService();
        Address address = addressService.findAddressById(aid);
        order.setAddress(address);
        User user = (User) request.getSession().getAttribute("user");
        order.setUser(user);
        order.setOrderCode(UUID.randomUUID().toString());
        order.setMoney(Double.valueOf(money));
        order.setStatus(1);
        order.setCreateTime(new Date());

        /**
         *  订单插入数据库再返回自增主键
         */
        OrderService orderService = new OrderService();
        int oid = orderService.addgetOrder(order);
        order.setId(oid);
        System.out.println(order);

        // 取购物车
        Map<Product,Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        if (cart==null||cart.size()==0){
            response.getWriter().write("购物车没有商品");
            return;
        }

        List<OrderItem> list = new ArrayList<OrderItem>();
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(entry.getKey());
            orderItem.setNumber(entry.getValue());
            orderItem.setOrder(order);
            list.add(orderItem);
            /**
             *  将订单项插入数据库
             */
            OrderItemService service = new OrderItemService();
            service.addOrderItem(orderItem);
        }

        /**
         *  再把订单详情放入订单中
         */
        order.setList(list);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),order);
    }

    /**
     *  查看当前用户的所有订单
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Order> list = service.findAllOrderByUserId(user.getId());

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  支付某订单
     *  在业务中要修改库存
     *  修改订单状态
     *  添加支付时间
     */
    public void payOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String oid = request.getParameter("oid");
        service.confirmPayOrder(oid);
    }

    /**
     *  某订单收货
     *  修改订单状态
     *  添加收货时间
     */
    public void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String oid = request.getParameter("oid");
        service.getStatus(oid);
    }

    /**
     *  对某订单进行评价
     *  修改订单状态
     */
    public void reviewOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String oid = request.getParameter("oid");
        service.reviewStatus(oid);
    }
    /**
     *  根据id查找某订单
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String oid = request.getParameter("oid");
        Order order = service.findOrderByOrderId(oid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),order);
    }


}
