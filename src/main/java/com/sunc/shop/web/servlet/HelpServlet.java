package com.sunc.shop.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.HelpArticle;
import com.sunc.shop.model.HelpCategory;
import com.sunc.shop.model.NewsPaper;
import com.sunc.shop.model.NewsPaperCategory;
import com.sunc.shop.service.HelpService;
import com.sunc.shop.service.NewsPaperService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/11 22:12
 */
@WebServlet("/help/*")
public class HelpServlet extends BaseServlet {

    private HelpService service = new HelpService();

    /**
     *  查找所有帮助中心文章
     *  按种类
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cid = request.getParameter("cid");
        List<HelpArticle> list = service.findAllByCid(cid);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }
    /**
     *  展示帮助中心所有类别
     */
    public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<HelpCategory> list = service.findAllCategory();
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }



 }
