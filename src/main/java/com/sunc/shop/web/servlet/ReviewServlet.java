package com.sunc.shop.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Favorite;
import com.sunc.shop.model.Review;
import com.sunc.shop.model.User;
import com.sunc.shop.service.FavoriteService;
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
@WebServlet("/review/*")
public class ReviewServlet extends BaseServlet {

    private ReviewService service = new ReviewService();

    /**
     *  查找某件商品的所有评论
     *  根据pid
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        List<Review> list = service.findReviewsByPId(pid);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  当前用户为某件商品添加评论
     */
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        String content = request.getParameter("content");
        User user = (User) request.getSession().getAttribute("user");
        service.addReview(user.getId()+"",pid,content);
    }
    /**
     *  找到当前用户用户的所有评论
     */
    public void findAll2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Review> list = service.findReviewsByUId(user.getId()+"");

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }
    /**
     *  找到当前用户关于某个商品的评论
     */
    public void deleteOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String rid = request.getParameter("rid");
        service.deleteReview(rid);
    }

 }
