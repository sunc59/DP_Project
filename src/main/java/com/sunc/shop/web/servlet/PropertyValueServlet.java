package com.sunc.shop.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.PropertyValue;
import com.sunc.shop.model.Review;
import com.sunc.shop.model.User;
import com.sunc.shop.service.PropertyValueService;
import com.sunc.shop.service.ReviewService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/11 22:12
 */
@WebServlet("/propertyValue/*")
public class PropertyValueServlet extends BaseServlet {

    private PropertyValueService service = new PropertyValueService();

    /**
     *  商品详情页的属性值
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        List<PropertyValue> list = service.findAllPVByPId(pid);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }



 }
