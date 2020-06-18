package com.sunc.shop.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.ResultInfo;
import com.sunc.shop.model.User;
import com.sunc.shop.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @auther sunc
 * @date 2020/5/2 17:17
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserService();

    /**
     *  访问控制符应该为public 不然的话就要暴力反射了
     *  注册用户
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException {
        /**
         *  验证码校验，正确才继续执行
         */
        /*String check = request.getParameter("check");
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        // 为防止验证码复用，验证码只能使用一次
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        if (checkcode_server==null||!checkcode_server.equalsIgnoreCase(check)){
            // 验证码错误
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getWriter(),info);
            return;

        }*/
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRegistTime(new Date());

        UserService service = new UserService();
        boolean flag = service.register(user);
        ResultInfo info = new ResultInfo();
        info.setFlag(flag);
        if (flag){
            // 注册成功
        }else {
            // 注册失败
            info.setErrorMsg("注册失败");
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),info);

    }

    /**
     *  用户登录
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /**
         *  先不做验证码校验
         */
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
            UserService service = new UserService();
            User u = service.login(user.getUsername(),user.getPassword());
            ResultInfo info = new ResultInfo();
            if (u==null){
                info.setFlag(false);
                info.setErrorMsg("用户名或密码错误");
            }
            if (u!=null&&"N".equals(u.getState())){
                info.setFlag(false);
                info.setErrorMsg("该用户尚未激活");
            }
            if (u!=null&&"Y".equals(u.getState())){
                request.getSession().setAttribute("user",u);
                info.setFlag(true);
            }
            System.out.println(info);
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getWriter(),info);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     *  用户退出
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    /**
     *  查找当前登录的用户
     *  存在session中
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),user);
    }

    /**
     *  激活用户
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*String code = request.getParameter("code");
        UserService service = new UserService();
        boolean flag = service.activeUser(code);

        String msg = null;
        if (flag){
            // 激活成功
            msg = "激活成功，<a href='login.html'>请登录</a>";
        }else {
            // 激活失败
            msg = "激活失败，请联系管理员";
        }
        response.getWriter().write(msg);*/
    }

    /**
     *  更新完善用户信息
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
            UserService service = new UserService();
            service.updateUser(user);
            request.getSession().invalidate();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
