package com.sunc.shop.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.PageBean;
import com.sunc.shop.model.Product;
import com.sunc.shop.service.ProductService;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/5/2 17:47
 */
@WebServlet("/product/*")
public class ProductServlet extends BaseServlet {

    private ProductService service = new ProductService();

    /**
     *  商品分页查询
     */
    public void pageFind(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        // 接收处理pName参数
        String pName = request.getParameter("pName");
        if (pName==null||pName.length()==0||"null".equals(pName)){
            pName="";
        }

        // 处理参数
        int cid = 0;
        if (cidStr!=null&&cidStr.length()>0&&!"null".equals(cidStr)){
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0;
        if (currentPageStr!=null&&currentPageStr.length()>0&&!"null".equals(currentPageStr)){
            currentPage = Integer.parseInt(currentPageStr);
        }else {
            currentPage = 1;
        }
        int pageSize = 0;
        if (pageSizeStr!=null&&pageSizeStr.length()>0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else {
            pageSize = 5;
        }

        PageBean<Product> pageBean = service.pageFind(cid,pName,currentPage,pageSize);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),pageBean);
    }

    /**
     *  找个某个商品
     *  根据pid
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("pid");
        Product product = service.findProductById(id);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),product);
    }
    /**
     *  根据商家id查找属于该商家的所有商品
     */
    public void findAllBySid(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String sid = request.getParameter("sid");
        List<Product> list = service.findAllBySid(sid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }


}
