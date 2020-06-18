package com.sunc.shop.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Address;
import com.sunc.shop.model.PageBean;
import com.sunc.shop.model.Product;
import com.sunc.shop.model.User;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.ProductService;
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
@WebServlet("/admin/product/*")
public class ProductServlet extends BaseServlet {

    private ProductService service = new ProductService();

    /**
     *  查询所有的商品，因为比较多，所以做分页处理
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String page = request.getParameter("page");
        if ("".equals(page)||"null".equals(page)||page==null){
            page = "1";
        }
        String pageSize = "5";

        PageBean<Product> list = service.findAllProductByPage(page, pageSize);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  查询某个商品，供更新用
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pid = request.getParameter("pid");
        Product product = service.findProductById(pid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),product);
    }

    /**
     *  更新某个商品
     */
    public void updateOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Product product = new Product();
        try {
            BeanUtils.populate(product,request.getParameterMap());
            service.updateProduct(product);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     *  删除某个商品
     */
    public void deleteOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pid = request.getParameter("pid");
        service.deleteProduct(pid);
    }

    /**
     *  增加某个商品
     */
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Product product = new Product();
        try {
            BeanUtils.populate(product,request.getParameterMap());
            service.addProduct(product);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
