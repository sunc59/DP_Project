package com.sunc.shop.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Address;
import com.sunc.shop.model.User;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.UserService;
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
@WebServlet("/admin/user/*")
public class UserServlet extends BaseServlet {

    private UserService service = new UserService();

    /**
     *  查询所有用户信息
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<User> list = service.findAllUser();

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  后台辅助激活用户
     *  修改状态为Y
     */
    public void activeOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uid = request.getParameter("uid");
        service.activeUser(uid);
    }

    /**
     *  后台更改用户角色
     */
    public void updateRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uid = request.getParameter("uid");
        String rid = request.getParameter("rid");
        service.updateRoleId(uid,rid);
    }
}
