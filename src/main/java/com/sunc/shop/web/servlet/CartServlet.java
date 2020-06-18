package com.sunc.shop.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.HelpArticle;
import com.sunc.shop.model.HelpCategory;
import com.sunc.shop.model.Product;
import com.sunc.shop.model.User;
import com.sunc.shop.service.HelpService;
import com.sunc.shop.service.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther sunc
 * @date 2020/6/11 22:12
 */
@WebServlet("/cart/*")
public class CartServlet extends BaseServlet {

    /**
     *  添加商品进购物车
     */
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        ProductService service = new ProductService();
        Product product = service.findProductById(pid);

        // 把商品放到购物车Map
        // 1.先从session里面取出map
        Map<Product,Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        if (cart==null){
            cart = new HashMap<Product, Integer>();
            cart.put(product,1);
        }else {
            // 判断map里面是否有当前想购买的商品
            /**
             * 需要重写product的equals方法，判断有无重复的商品存在
             */
            if (cart.containsKey(product)){
                cart.put(product,cart.get(product)+1);
            }else {
                cart.put(product,1);
            }
        }
        // 打印购物车
        for (Product p : cart.keySet()) {
            System.out.println(p+"..."+cart.get(p));
        }

        // 存到session中
        request.getSession().setAttribute("cart",cart);

    }

    /**
     *  改变购物车中商品数量
     */
    public void changeNumber(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.获取数据
        String pid = request.getParameter("pid");
        String num = request.getParameter("num");

        // 2.更新购物车数据
        // 2.1根据id查找商品
        ProductService service = new ProductService();
        Product product = service.findProductById(pid);
        // 2.2通过商品更新session数据
        Map<Product,Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        if (cart.containsKey(product)){
            if ("0".equals(num)){
                cart.remove(product);
            }else {
                cart.put(product,Integer.parseInt(num));
            }
        }
        // 重新保存到session中
        request.getSession().setAttribute("cart",cart);
    }
    /**
     *  查询购物车
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<Product,Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),cart);
    }
}
