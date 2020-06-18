package com.sunc.shop.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Address;
import com.sunc.shop.model.Category;
import com.sunc.shop.model.User;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.CategoryService;
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
@WebServlet("/admin/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService service = new CategoryService();

    /**
     *  查询所有的商品类别
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Category> list = service.findAllCategory();

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }
    /**
     *  查询某个商品类别
     *  供修改用
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String cid = request.getParameter("cid");
        Category category = service.findCategory(cid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),category);
    }
    /**
     *  删除某个商品类别
     */
    public void deleteOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String cid = request.getParameter("cid");
        service.deleteCategory(cid);
    }

    /**
     *  修改某个商品类别
     */
    public void updateOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String cid = request.getParameter("cid");
        String name = request.getParameter("name");
        service.updateCategory(cid,name);
    }
    /**
     *  增加一个商品类别
     */
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        service.addCategory(name);
    }



}
