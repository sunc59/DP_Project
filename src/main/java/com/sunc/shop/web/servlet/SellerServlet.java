package com.sunc.shop.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Review;
import com.sunc.shop.model.Seller;
import com.sunc.shop.model.User;
import com.sunc.shop.service.ReviewService;
import com.sunc.shop.service.SellerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/11 22:12
 */
@WebServlet("/seller/*")
public class SellerServlet extends BaseServlet {

    private SellerService service = new SellerService();

    /**
     *  查找所有商家
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Seller> list = service.findAllSeller();
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  根据id查找商家
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sid = request.getParameter("sid");
        Seller seller = service.findSellerById(sid);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),seller);
    }

    /**
     *  根据name查找商家，模糊查找
     */
    public void findOne2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sName = request.getParameter("sName");
        List<Seller> seller = service.findSellerByName(sName);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),seller);
    }

 }
