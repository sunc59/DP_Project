package com.sunc.shop.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Address;
import com.sunc.shop.model.Property;
import com.sunc.shop.model.User;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.PropertyService;
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
@WebServlet("/admin/property/*")
public class PropertyServlet extends BaseServlet {

    private PropertyService service = new PropertyService();

    /**
     *  查询某个商品类别的所有属性
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String cid = request.getParameter("cid");
        List<Property> list = service.findAllPropertyByCid(cid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }
    /**
     *  查询某个属性
     *  共更新用
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pid = request.getParameter("pid");
        Property property = service.findPropertyByPid(pid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),property);
    }

    /**
     *  删除某个属性
     */
    public void deleteOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pid = request.getParameter("pid");
        service.deleteProperty(pid);
    }
    /**
     *  修改某个属性的名称
     */
    public void updateOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pid = request.getParameter("pid");
        String name = request.getParameter("name");
        service.updateProperty(pid,name);
    }
    /**
     *  增加一个属性
     */
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        service.addProperty(name);
    }
}
