package com.sunc.shop.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.NewsPaper;
import com.sunc.shop.model.NewsPaperCategory;
import com.sunc.shop.model.PropertyValue;
import com.sunc.shop.service.NewsPaperService;
import com.sunc.shop.service.PropertyValueService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/11 22:12
 */
@WebServlet("/newsPaper/*")
public class NewsPaperServlet extends BaseServlet {

    private NewsPaperService service = new NewsPaperService();

    /**
     *  京东快报展示
     *  按类别
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cid = request.getParameter("cid");
        List<NewsPaper> list = service.findAllByCid(cid);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }
    /**
     *  展示京东快报的所有种类
     */
    public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<NewsPaperCategory> list = service.findAllCategory();
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }



 }
