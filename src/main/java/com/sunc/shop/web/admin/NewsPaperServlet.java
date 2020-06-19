package com.sunc.shop.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.*;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.NewsPaperService;
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
@WebServlet("/admin/newsPaper/*")
public class NewsPaperServlet extends BaseServlet {

    private NewsPaperService service = new NewsPaperService();

    /**
     *  根据种类id查询所有的文章
     */
    public void findAllArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String cid = request.getParameter("cid");
        List<NewsPaper> list = service.findAllArticleByCid(cid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  根据id查询某一个具体的文章
     */
    public void findArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String aid = request.getParameter("aid");
        NewsPaper newsPaper = service.findArticle(aid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),newsPaper);
    }
    /**
     *  新增一篇文章
     */
    public void addArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {

        NewsPaper newsPaper = new NewsPaper();
        try {
            BeanUtils.populate(newsPaper,request.getParameterMap());
            service.addArticle(newsPaper);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     *  更新一篇文章
     */
    public void updateArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {

        NewsPaper newsPaper = new NewsPaper();
        try {
            BeanUtils.populate(newsPaper,request.getParameterMap());
            service.updateArticle(newsPaper);
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

    /**
     *  增加文章的访问量
     */
    public void changeCount(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String aid = request.getParameter("aid");
        service.changeArticleCount(aid);
    }


    /**
     *  增加一个快报种类
     */
    public void addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        service.addCategory(name);
    }

    /**
     *  删除一个快报种类
     */
    public void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String cid = request.getParameter("cid");
        service.deleteCategory(cid);
    }
    /**
     *  查看所有的快报种类
     */
    public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<NewsPaperCategory> list = service.findAllCategory();
    }

}
