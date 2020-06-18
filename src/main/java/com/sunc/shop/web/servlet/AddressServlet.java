package com.sunc.shop.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Address;
import com.sunc.shop.model.User;
import com.sunc.shop.service.AddressService;
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
@WebServlet("/address/*")
public class AddressServlet extends BaseServlet {

    private AddressService service = new AddressService();

    /**
     *  查询当前用户的所有地址
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Address> list = service.findAddressByUser(user.getId()+"");
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  为当前用户增加一个新地址
     */
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Address address = new Address();
        try {
            BeanUtils.populate(address,request.getParameterMap());
            System.out.println(address);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        service.addAddress(address,user.getId()+"");
    }

    /**
     *  删除某个地址
     */
    public void deleteOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String aid = request.getParameter("aid");
        service.deleteAddress(aid);
    }
}
