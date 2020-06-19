package com.sunc.shop.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Address;
import com.sunc.shop.model.HelpArticle;
import com.sunc.shop.model.HelpCategory;
import com.sunc.shop.model.User;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.HelpService;
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
@WebServlet("/admin/help/*")
public class HelpServlet extends BaseServlet {

    private HelpService service = new HelpService();

    /**
     *  查询所有的帮助中心类别及文章
     *  查询帮助类别，里面包含文章的列表
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<HelpCategory> list = service.findAllCategory();

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  根据id查询某一个具体的文章
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String hid = request.getParameter("hid");
        HelpArticle article = service.findHelpById(hid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),article);
    }

    /**
     *  增加一个文章种类
     */
    public void addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        service.addCategory(name);
    }

    /**
     *  删除一个文章种类
     */
    public void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String cid = request.getParameter("cid");
        service.deleteCategory(cid);
    }
    /**
     *  新增一篇文章
     */
    public void addArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HelpArticle article = new HelpArticle();
        try {
            BeanUtils.populate(article,request.getParameterMap());
            service.addArticle(article);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    /**
     *  删除一篇文章
     */
    public void deleteArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String aid = request.getParameter("aid");
        service.deleteArticle(aid);
    }

}
