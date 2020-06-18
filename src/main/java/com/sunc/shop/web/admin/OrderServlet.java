package com.sunc.shop.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Address;
import com.sunc.shop.model.Order;
import com.sunc.shop.model.User;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.OrderService;
import com.sunc.shop.web.servlet.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/11 22:12
 */
@WebServlet("/admin/order/*")
public class OrderServlet extends BaseServlet {

    private OrderService service = new OrderService();

    /**
     *  查询所有的订单及订单详细信息
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Order> list = service.findAllOrders();

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  查询某一个订单的详细信息
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String oid = request.getParameter("oid");
        Order order = service.findOrderByOrderId(oid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),order);
    }

    /**
     *  某一个订单发货
     */
    public void faHuo(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String oid = request.getParameter("oid");
        service.faHuo(oid);
    }

}
