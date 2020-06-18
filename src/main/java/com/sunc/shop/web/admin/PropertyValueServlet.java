package com.sunc.shop.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Address;
import com.sunc.shop.model.PropertyValue;
import com.sunc.shop.model.User;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.PropertyValueService;
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
@WebServlet("/admin/propertyValue/*")
public class PropertyValueServlet extends BaseServlet {

    private PropertyValueService service = new PropertyValueService();


    /**
     *  为当前这个类别的这个商品增添一个属性值
     *  属性来自于当前这个类别
     *  属性值自己定义
     */
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        String ptid = request.getParameter("ptid");
        String value = request.getParameter("value");

        service.addPropertyValue(pid,ptid,value);
    }

    /**
     *  查看某商品的所有属性值
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");

        List<PropertyValue> list = service.findAllPVByPId(pid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  删除某个属性值
     */
    public void deleteOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        service.deletePropertyValue(id);
    }
    /**
     *  修改某个属性值
     */
    public void updateOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String value = request.getParameter("value");
        service.updatePropertyValue(id,value);
    }

}
