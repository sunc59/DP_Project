package com.sunc.shop.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Address;
import com.sunc.shop.model.Role;
import com.sunc.shop.model.Seller;
import com.sunc.shop.model.User;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.SellerService;
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
@WebServlet("/admin/seller/*")
public class SellerServlet extends BaseServlet {

    private SellerService service = new SellerService();

    /**
     *  查询所有商家
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Seller> list = service.findAllSeller();

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  查询某个商家
     *  供更新用
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String sid = request.getParameter("sid");
        Seller seller = service.findSellerById(sid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),seller);
    }

    /**
     *  删除某个商家
     */
    public void deleteOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String sid = request.getParameter("sid");
        service.deleteSeller(sid);
    }

    /**
     *  更新某个商家
     */
    public void updateOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Seller seller = new Seller();
        try {
            BeanUtils.populate(seller,request.getParameterMap());
            service.updateSeller(seller);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    /**
     *  增加某个商家
     */
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Seller seller = new Seller();
        try {
            BeanUtils.populate(seller,request.getParameterMap());
            service.addSeller(seller);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
