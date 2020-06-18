package com.sunc.shop.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Address;
import com.sunc.shop.model.Favorite;
import com.sunc.shop.model.Product;
import com.sunc.shop.model.User;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.FavoriteService;
import com.sunc.shop.service.ProductService;
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
@WebServlet("/favorite/*")
public class FavoriteServlet extends BaseServlet {

    private FavoriteService service = new FavoriteService();

    /**
     *  展示收藏排行榜的数据
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Favorite> list = service.findRank();
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }
    /**
     *  展示当前用户收藏的物品
     *  我的收藏
     */
    public void findCurrent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Product> list = service.findMyFavorite(user.getId());
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }
    /**
     *   判断
     *   当前用户是否收藏某商品
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        User user = (User) request.getSession().getAttribute("user");
        List<Product> list = service.findMyFavorite(user.getId());
        boolean flag = false;
        for (Product p : list) {
            if (p.getId()==Integer.parseInt(pid)){
                flag = true;
                break;
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),flag);
    }

    /**
     *  为当前用户收藏某商品
     */
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String pid = request.getParameter("pid");
        service.addFavorite(user.getId()+"",pid);
    }
}
