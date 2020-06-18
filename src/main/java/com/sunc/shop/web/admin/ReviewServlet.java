package com.sunc.shop.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Address;
import com.sunc.shop.model.Review;
import com.sunc.shop.model.User;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.ReviewService;
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
@WebServlet("/admin/review/*")
public class ReviewServlet extends BaseServlet {

    private ReviewService service = new ReviewService();

    /**
     *  查询某个用户的所有评论
     */
    public void findUserAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uid = request.getParameter("uid");
        List<Review> list = service.findReviewsByUId(uid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  查询某个商品的所有评论
     */
    public void findProductAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pid = request.getParameter("pid");
        List<Review> list = service.findReviewsByPId(pid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }
    /**
     *  查询某个用户关于某个商品的评论
     *  用于后台在查找某个具体的评论的时候
     */
    public void findUserProductOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uid = request.getParameter("uid");
        String pid = request.getParameter("pid");
        Review review = service.findReviewsByUIdPId(uid,pid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),review);
    }

    /**
     *  删除某个评论
     */
    public void deleteOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String rid = request.getParameter("rid");
        service.deleteReview(rid);
    }
}
