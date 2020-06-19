package com.sunc.shop.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Role;
import com.sunc.shop.service.RoleService;
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
@WebServlet("/role/*")
public class RoleServlet extends BaseServlet {

    private RoleService service = new RoleService();

    /**
     *  查询所有角色
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Role> list = service.findAllRole();

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }
}
