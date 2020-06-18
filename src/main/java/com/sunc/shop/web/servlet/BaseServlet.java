package com.sunc.shop.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther sunc
 * @date 2020/5/2 17:07
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BaseServlet的service方法被执行");
        // 1.获取请求路径 travel/user/regist
        String uri = request.getRequestURI();
        // 2.获取方法名
        String method = uri.substring(uri.lastIndexOf("/") + 1);
        // 3.获取方法对象Method
        try {
            // 谁调用我，this代表谁。UserServlet
            // 获取方法
            Method m = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            // 4.执行方法
            // 暴力反射
            //m.setAccessible(true);
            m.invoke(this,request,response);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
