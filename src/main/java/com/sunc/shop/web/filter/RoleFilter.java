package com.sunc.shop.web.filter;



import com.sunc.shop.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther sunc
 * @date 2020/3/28 21:24
 */
@WebFilter("/admin/*")
public class RoleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            if (!"管理员".equals(user.getRole())){
                response.getWriter().write("权限不足，没有管理员权限，请用管理员账号登陆");
                return;
            }else {
                filterChain.doFilter(request,response);
                return;
            }
        }
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    @Override
    public void destroy() {

    }
}
